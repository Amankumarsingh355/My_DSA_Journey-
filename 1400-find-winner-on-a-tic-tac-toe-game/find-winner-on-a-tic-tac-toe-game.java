class Solution {
    public String tictactoe(int[][] moves) {
        char[][] board = new char[3][3];
        for (int i = 0; i < moves.length; i++) {
            char ch = i % 2 == 0 ? 'X' : 'O';
            board[moves[i][0]][moves[i][1]] = ch;
        }
        int rowA = 0;
        int columnA = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char row = board[i][j];
                char col = board[j][i];
                if (row == 'X') {
                    rowA++;
                } else if (row == 'O') {
                    rowA--;
                }
                if (col == 'X') {
                    columnA++;
                } else if (col == 'O') {
                    columnA--;
                }
            }
            if (rowA == 3 || columnA == 3) {
                return "A";
            } else if (rowA == -3 || columnA == -3) {
                return "B";
            }
            rowA = 0;
            columnA = 0;
        }
        if (checkDiag(board, 'X')) {
            return "A";
        }
        if (checkDiag(board, 'O')) {
            return "B";
        }
        return moves.length == 9 ? "Draw" : "Pending";
    }
    private boolean checkDiag(char[][] board, char ch) {
        return (board[0][0] == ch && board[1][1] == ch && board[2][2] == ch) ||
                (board[0][2] == ch && board[1][1] == ch && board[2][0] == ch);
    }
}