class Solution {
    private boolean isValid(char[][] board, int row, int col, char ch) {
        for (int k = 0; k < 9; k++) {

            // Check row
            if (board[row][k] == ch)
                return false;

            // Check column
            if (board[k][col] == ch)
                return false;

            // Check 3 x 3 box
            if (board[3 * (row / 3) + k / 3]
                    [3 * (col / 3) + k % 3] == ch)
                return false;
        }
        return true;
    }

    private boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char ch = '1'; ch <= '9'; ch++) {
                        if (isValid(board, i, j, ch)) {
                            board[i][j] = ch;
                            if (solve(board))
                                return true;

                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public void solveSudoku(char[][] board) {
        solve(board);
    }
}