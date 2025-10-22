public class Solution {
    private int rows, cols;
    private char[][] board;
    private String word;
    private boolean[][] seen;
    private final int[] dr = { -1, 1, 0, 0 };
    private final int[] dc = { 0, 0, -1, 1 };
    public boolean exist(char[][] board, String word) {
        this.rows = board.length;
        if (rows == 0) return false;
        this.cols = board[0].length;
        this.board = board;
        this.word = word;
        this.seen = new boolean[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == word.charAt(0) && dfs(r, c, 0)) return true;
            }
        }
        return false;
    }
    private boolean dfs(int r, int c, int idx) {
        if (idx == word.length()) return true;
        if (r < 0 || r >= rows || c < 0 || c >= cols) return false;
        if (seen[r][c]) return false;
        if (board[r][c] != word.charAt(idx)) return false;
        seen[r][c] = true;
        for (int k = 0; k < 4; k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];
            if (dfs(nr, nc, idx + 1)) {
                seen[r][c] = false;
                return true;
            }
        }
        seen[r][c] = false;
        return false;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] board = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };
        System.out.println(s.exist(board, "ABCCED"));
        System.out.println(s.exist(board, "SEE"));    
        System.out.println(s.exist(board, "ABCB"));
    }
}