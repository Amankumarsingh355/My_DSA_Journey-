class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m=image.length;
        int n=image[0].length;
        int oldColor=image[sr][sc];
        if(oldColor==color) return image;
        Queue<int[]> queue=new ArrayDeque<>();
        queue.offer(new int[]{sr,sc});
        int[][] dir={{1,0},{0,1},{-1,0},{0,-1}};
        while(!queue.isEmpty()){
            int[] curr=queue.poll();
            int r=curr[0];
            int c=curr[1];
            image[r][c]=color;
            for(int[] d:dir){
                int nr=r+d[0];
                int nc=c+d[1];
                if(nr>=0 && nr<m && nc>=0 && nc<n && image[nr][nc]==oldColor){
                    image[nr][nc]=color;
                    queue.offer(new int[]{nr,nc});
                }
            }
        }
        return image;
    }
}