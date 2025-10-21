public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int i = 0, n = intervals.length;
        while (i < n && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i++]);
        }
        int start = newInterval[0], end = newInterval[1];
        while (i < n && intervals[i][0] <= end) {
            start = Math.min(start, intervals[i][0]);
            end = Math.max(end, intervals[i][1]);
            i++;
        }
        res.add(new int[]{start, end});
        while (i < n) {
            res.add(intervals[i++]);
        }
        return res.toArray(new int[res.size()][]);
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] a1 = {{1,3},{6,9}};
        int[] ni1 = {2,5};
        System.out.println(Arrays.deepToString(s.insert(a1, ni1)));
        int[][] a2 = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] ni2 = {4,8};
        System.out.println(Arrays.deepToString(s.insert(a2, ni2)));
    }
}