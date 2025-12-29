class Solution {
    public int oddCells(int n, int m, int[][] indices) {
        int[] row = new int[n];
        int[] col = new int[m];
        for (int[] x : indices) {
            row[x[0]]++;
            col[x[1]]++;
        }
        int oddRows = 0, oddCols = 0;
        for (int i = 0; i < n; i++) {
            if (row[i] % 2 != 0) oddRows++;
        }
        for (int j = 0; j < m; j++) {
            if (col[j] % 2 != 0) oddCols++;
        }
        return oddRows * (m - oddCols) + (n - oddRows) * oddCols;
    }
}