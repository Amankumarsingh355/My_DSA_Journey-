class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Set<String> dict = new HashSet<>(wordDict);
        int maxLen = 0;
        for (String w : wordDict) maxLen = Math.max(maxLen, w.length());
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            int start = Math.max(0, i - maxLen);
            for (int j = i - 1; j >= start; j--) {
                if (!dp[j]) continue;
                if (dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.wordBreak("leetcode", Arrays.asList("leet","code")));
        System.out.println(sol.wordBreak("applepenapple", Arrays.asList("apple","pen")));
        System.out.println(sol.wordBreak("catsandog", Arrays.asList("cats","dog","sand","and","cat")));
    }
}