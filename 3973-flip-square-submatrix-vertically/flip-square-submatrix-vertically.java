class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        for (int i = 0; i < k; i++) {
            reverseColumn(grid, x, y + i, k);
        }
        return grid;
    }
    public void reverseColumn(int[][] grid, int r, int c, int k) {
        int s = r, e = r + k - 1;
        while (s < e) {
            int temp = grid[s][c];
            grid[s][c] = grid[e][c];
            grid[e][c] = temp;
            s++;
            e--;
        }
    }
}