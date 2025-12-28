class Solution {
    private int count = 0;
    public int numRookCaptures(char[][] board) {
        int x = -1;
        int y = -1;
        outer: for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    x = i;
                    y = j;
                    break outer;
                }
            }
        }
        for (int i = y + 1; i < 8; i++) {
            if (processCellAndStop(board[x][i])) {
                break;
            }
        }
        for (int i = y - 1; i >= 0; i--) {
            if (processCellAndStop(board[x][i])) {
                break;
            }
        }
        for (int i = x + 1; i < 8; i++) {
            if (processCellAndStop(board[i][y])) {
                break;
            }
        }
        for (int i = x - 1; i >= 0; i--) {
            if (processCellAndStop(board[i][y])) {
                break;
            }
        }
        return count;
    }
    private boolean processCellAndStop(char ch) {
        if (ch == 'B') {
            return true;
        } else if (ch == 'p') {
            count++;
            return true;
        }
        return false;
    }
}