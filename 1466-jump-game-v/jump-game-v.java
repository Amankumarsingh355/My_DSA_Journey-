class Solution {
    int[] dp;
    private int dfs(int i, int[] arr, int d) {
        if (dp[i] != -1)
            return dp[i];
        int ans = 1;
        for (int j = i + 1; j <= Math.min(arr.length - 1, i + d); j++) {
            if (arr[j] >= arr[i])
                break;
            ans = Math.max(ans, 1 + dfs(j, arr, d));
        }
        for (int j = i - 1; j >= Math.max(0, i - d); j--) {
            if (arr[j] >= arr[i])
                break;
            ans = Math.max(ans, 1 + dfs(j, arr, d));
        }
        return dp[i] = ans;
    }
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = -1;
        }
        int answer = 1;
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, dfs(i, arr, d));
        }
        return answer;
    }
}