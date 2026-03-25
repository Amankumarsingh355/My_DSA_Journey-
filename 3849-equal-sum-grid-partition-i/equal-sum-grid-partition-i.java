class Solution {
    int n, m;

    boolean checkHz(int[][] grid){
        HashSet<Long> st = new HashSet<>();

        long pref = 0;

        for(int i = 0; i < n; i++){
            long rowSum = 0;
            for(int j = 0; j < m; j++){
                rowSum += grid[i][j];
            }
            pref += rowSum;
            st.add(pref);
        }

        if(pref % 2 != 0) return false;

        return st.contains(pref / 2);
    }

    boolean checkVz(int[][] grid){
        HashSet<Long> st = new HashSet<>();

        long pref = 0;

        for(int j = 0; j < m; j++){
            long colSum = 0;
            for(int i = 0; i < n; i++){
                colSum += grid[i][j];
            }
            pref += colSum;
            st.add(pref);
        }

        if(pref % 2 != 0) return false;

        return st.contains(pref / 2);
    }

    public boolean canPartitionGrid(int[][] grid) {
        n = grid.length;
        m = grid[0].length;

        return checkHz(grid) || checkVz(grid);
    }
}