public class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) return 0;
        Arrays.sort(points, (a, b) -> Long.compare(a[1], b[1]));
        int arrows = 0;
        long curEnd = Long.MIN_VALUE;
        for (int[] p : points) {
            long start = p[0];
            long end = p[1];
            if (arrows == 0 || start > curEnd) {
                arrows++;
                curEnd = end;
            }
        }
        return arrows;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findMinArrowShots(new int[][]{{10,16},{2,8},{1,6},{7,12}}));
        System.out.println(s.findMinArrowShots(new int[][]{{1,2},{3,4},{5,6},{7,8}}));
        System.out.println(s.findMinArrowShots(new int[][]{{1,2},{2,3},{3,4},{4,5}}));
    }
}