public class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if (m == 0) return n;
        if (n == 0) return m;
        int[] dp = new int[n + 1];
        for (int j = 0; j <= n; j++) dp[j] = j;
        for (int i = 1; i <= m; i++) {
            int prevDiag = dp[0];
            dp[0] = i;
            for (int j = 1; j <= n; j++) {
                int temp = dp[j];
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[j] = prevDiag;
                } else {
                    dp[j] = 1 + Math.min(Math.min(dp[j], dp[j - 1]), prevDiag);
                }
                prevDiag = temp;
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minDistance("horse", "ros"));     
        System.out.println(s.minDistance("intention", "execution"));
        System.out.println(s.minDistance("", "abc"));
        System.out.println(s.minDistance("abc", ""));
    }
}