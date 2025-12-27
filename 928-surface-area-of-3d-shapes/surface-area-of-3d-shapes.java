class Solution {
    public int surfaceArea(int[][] grid) {
        int total = 0;
        int size = grid.length;
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                if (grid[i][j] == 0){
                    continue;
                }
                int areaGained = 4 * grid[i][j] + 2;
                int areaLost = 0;
                if (i - 1 >= 0){
                    areaLost += Math.min(grid[i][j], grid[i - 1][j]);
                }
                if (i + 1 < size){
                    areaLost += Math.min(grid[i][j], grid[i + 1][j]);
                }
                if (j - 1 >= 0){
                    areaLost += Math.min(grid[i][j], grid[i][j - 1]);
                }
                if (j + 1 < size){
                    areaLost += Math.min(grid[i][j], grid[i][j + 1]);
                }
                total += areaGained - areaLost;
            }
        }
        return total;
    }
}