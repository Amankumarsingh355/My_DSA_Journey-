class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int x : nums) total += x;
        if ((total & 1) == 1) return false;
        int target = total / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int num : nums) {
            if (num > target) continue;
            for (int t = target; t >= num; t--) {
                if (dp[t - num]) dp[t] = true;
            }
            if (dp[target]) return true;
        }
        return dp[target];
    }
}