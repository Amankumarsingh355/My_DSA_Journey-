class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if (mat.length * mat[0].length != r * c) {
            return mat;
        }
        int[][] output = new int[r][c];
        for (int idx = 0; idx < r * c; idx++) {
            output[idx/c][idx % c] = mat[idx / mat[0].length][idx % mat[0].length];
        }
        return output; 
    }
}