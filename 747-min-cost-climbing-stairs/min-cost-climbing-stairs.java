public class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int a = cost[0];
        int b = cost[1];
        for (int i = 2; i < n; ++i) {
            int cur = cost[i] + Math.min(a, b);
            a = b;
            b = cur;
        }
        return Math.min(a, b);
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minCostClimbingStairs(new int[] {10,15,20}));
        System.out.println(s.minCostClimbingStairs(new int[] {1,100,1,1,1,100,1,1,100,1}));
    }
}