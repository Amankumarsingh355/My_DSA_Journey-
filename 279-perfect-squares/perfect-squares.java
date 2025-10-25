public class Solution {
    public int numSquares(int n) {
        if (n <= 0) return 0;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numSquares(12));
        System.out.println(s.numSquares(13));
        System.out.println(s.numSquares(1)); 
        System.out.println(s.numSquares(100)); 
    }
}