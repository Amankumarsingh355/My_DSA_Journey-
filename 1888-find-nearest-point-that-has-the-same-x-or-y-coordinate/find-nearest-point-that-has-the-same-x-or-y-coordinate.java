class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int minManh = Integer.MAX_VALUE;
        int indMin = -1;
        for (int i = 0; i < points.length; i++)
        {
            int tmpManh = Math.abs(x - points[i][0]) + Math.abs(y - points[i][1]);
            if ((x == points[i][0] || y == points[i][1]) && (tmpManh < minManh))
            {
                minManh = tmpManh;
                indMin = i;
            }
        }
        return indMin;
    }
}