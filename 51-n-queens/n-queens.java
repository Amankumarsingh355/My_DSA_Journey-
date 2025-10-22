public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2 * n]; 
        boolean[] diag2 = new boolean[2 * n];
        int[] queenCol = new int[n];
        backtrack(0, n, cols, diag1, diag2, queenCol, res);
        return res;
    }
    private void backtrack(int row, int n, boolean[] cols, boolean[] diag1, boolean[] diag2,
                           int[] queenCol, List<List<String>> res) {
        if (row == n) {
            res.add(buildBoard(queenCol, n));
            return;
        }
        for (int c = 0; c < n; c++) {
            int d1 = row - c + n;
            int d2 = row + c;
            if (cols[c] || diag1[d1] || diag2[d2]) continue;
            cols[c] = true;
            diag1[d1] = true;
            diag2[d2] = true;
            queenCol[row] = c;
            backtrack(row + 1, n, cols, diag1, diag2, queenCol, res);
            cols[c] = false;
            diag1[d1] = false;
            diag2[d2] = false;
        }
    }
    private List<String> buildBoard(int[] queenCol, int n) {
        List<String> board = new ArrayList<>(n);
        for (int r = 0; r < n; r++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queenCol[r]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solveNQueens(4));
    }
}