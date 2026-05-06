class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length; 
        int n = box[0].length; 
        
        char[][] res = new char[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (box[i][j] == '*') {
                    res[j][m - i - 1] = '*';
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (box[i][j] == '#') {
                    res = applyGravity(res, j, m - i - 1, m, n);
                }
            }
        }
        // Fill empty spaces with '.'
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                if (res[i][j] != '*' && res[i][j] != '#') {
                    res[i][j] = '.';
                }
            }
        }
        return res;
    }
    
    private char[][] applyGravity(char[][] res, int row, int col, int colLimit, int rowLimit) {
        while (row < rowLimit) {
            if (res[row][col] != '*' && res[row][col] != '#') {
                row++;
            } else {
                break; 
            }
        }
        res[row - 1][col] = '#'; 
        return res;
    }
}