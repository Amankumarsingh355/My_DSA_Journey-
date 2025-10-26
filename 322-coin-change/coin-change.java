class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int INF = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        for (int coin : coins) {
            for (int x = coin; x <= amount; x++) {
                dp[x] = Math.min(dp[x], dp[x - coin] + 1);
            }
        }
        return dp[amount] == INF ? -1 : dp[amount];
    }
}