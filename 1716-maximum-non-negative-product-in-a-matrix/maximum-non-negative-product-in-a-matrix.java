class Solution {
    public int maxProductPath(int[][] grid) {
        long[][] maxDp= new long[grid.length][grid[0].length];
        long[][] minDp = new long[grid.length][grid[0].length];
        maxDp[0][0]=grid[0][0];
        minDp[0][0]=grid[0][0];
        for(int i=1;i<grid[0].length;i++){
            maxDp[0][i] = maxDp[0][i-1] * grid[0][i];
            minDp[0][i] = minDp[0][i-1] * grid[0][i];
        }
        for(int i=1;i<grid.length;i++){
            maxDp[i][0]=maxDp[i-1][0]*grid[i][0];
            minDp[i][0]=minDp[i-1][0]*grid[i][0];
        }
        for(int i=1;i<grid.length;i++){
            for(int j=1;j<grid[i].length;j++){
                long val = grid[i][j];
                long a = val * maxDp[i-1][j];
                long b = val * minDp[i-1][j];
                long c = val * maxDp[i][j-1];
                long d = val * minDp[i][j-1];
                maxDp[i][j]=Math.max(Math.max(a,b),Math.max(c,d));
                minDp[i][j]=Math.min(Math.min(a,b),Math.min(c,d));
            }
        }
        long ans=maxDp[grid.length-1][grid[0].length-1];
        if(ans<0){
            return -1;
        }
        int MOD = 1000000007;
        return (int)(ans%MOD);
    }
}