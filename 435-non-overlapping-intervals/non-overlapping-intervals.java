import java.util.Arrays;
import java.util.Comparator;
public class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int kept = 0;
        int prevEnd = Integer.MIN_VALUE;
        for (int[] iv : intervals) {
            if (iv[0] >= prevEnd) {
                kept++;
                prevEnd = iv[1];
            }
        }
        return intervals.length - kept;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.eraseOverlapIntervals(new int[][]{{1,2},{2,3},{3,4},{1,3}}));
        System.out.println(s.eraseOverlapIntervals(new int[][]{{1,2},{1,2},{1,2}}));
        System.out.println(s.eraseOverlapIntervals(new int[][]{{1,2},{2,3}}));
    }
}