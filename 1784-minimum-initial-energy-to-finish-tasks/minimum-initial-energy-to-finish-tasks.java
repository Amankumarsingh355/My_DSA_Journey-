class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> (b[1] - b[0]) - (a[1] - a[0]));
        int used = 0, ans = 0;
        for (int[] t : tasks) {
            ans = Math.max(ans, used + t[1]);
            used += t[0];
        }
        return ans;
    }
}