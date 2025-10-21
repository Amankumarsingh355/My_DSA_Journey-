public class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) return intervals;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> merged = new ArrayList<>();
        int[] cur = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];
            if (next[0] <= cur[1]) {
                cur[1] = Math.max(cur[1], next[1]);
            } else {
                merged.add(cur);
                cur = next;
            }
        }
        merged.add(cur);
        return merged.toArray(new int[merged.size()][]);
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] a1 = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println(Arrays.deepToString(s.merge(a1)));
        int[][] a2 = {{1,4},{4,5}};
        System.out.println(Arrays.deepToString(s.merge(a2)));
    }
}