public class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char ch = board[r][c];
                if (ch == '.') continue;
                int val = ch - '1';
                if (val < 0 || val >= 9) return false;
                if (rows[r][val]) return false;
                rows[r][val] = true;
                if (cols[c][val]) return false;
                cols[c][val] = true;
                int boxIndex = (r / 3) * 3 + (c / 3);
                if (boxes[boxIndex][val]) return false;
                boxes[boxIndex][val] = true;
            }
        }
        return true;
    }
}