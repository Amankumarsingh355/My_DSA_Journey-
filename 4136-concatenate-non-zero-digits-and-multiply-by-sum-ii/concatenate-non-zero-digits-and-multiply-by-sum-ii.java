class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        final long MOD = 1_000_000_007L;
        int n = s.length();
        int[] nonZeroCount = new int[n + 1];
        for (int i = 0; i < n; i++) {
            nonZeroCount[i + 1] =
                nonZeroCount[i] + (s.charAt(i) != '0' ? 1 : 0);
        }
        int k = nonZeroCount[n];
        int[] digits = new int[k];
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != '0') {
                digits[index++] = s.charAt(i) - '0';
            }
        }
        long[] prefixValue = new long[k + 1];
        long[] prefixSum = new long[k + 1];
        long[] power10 = new long[k + 1];
        power10[0] = 1;
        for (int i = 0; i < k; i++) {
            prefixValue[i + 1] =
                (prefixValue[i] * 10 + digits[i]) % MOD;
            prefixSum[i + 1] =
                prefixSum[i] + digits[i];
            power10[i + 1] =
                (power10[i] * 10) % MOD;
        }
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int left = nonZeroCount[l];
            int right = nonZeroCount[r + 1];
            int len = right - left;
            long x = (
                prefixValue[right]
                - (prefixValue[left] * power10[len]) % MOD
                + MOD
            ) % MOD;
            long sum =
                prefixSum[right] - prefixSum[left];
            answer[i] = (int)((x * sum) % MOD);
        }
        return answer;
    }
}