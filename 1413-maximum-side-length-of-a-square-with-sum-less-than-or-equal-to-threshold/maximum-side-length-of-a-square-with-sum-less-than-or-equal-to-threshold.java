class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length, n = mat[0].length;
        long[][] pre = new long[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            long rowSum = 0;
            for (int j = 1; j <= n; j++) {
                rowSum += mat[i - 1][j - 1];
                pre[i][j] = pre[i - 1][j] + rowSum;
            }
        }
        int lo = 0, hi = Math.min(m, n);
        while (lo < hi) {
            int mid = (lo + hi + 1) >>> 1;
            if (can(pre, mid, threshold))
                lo = mid;
            else
                hi = mid - 1;
        }
        return lo;
    }
    private boolean can(long[][] pre, int len, int threshold) {
        for (int i = len; i < pre.length; i++) {
            for (int j = len; j < pre[0].length; j++) {
                long sum = pre[i][j]
                        - pre[i - len][j]
                        - pre[i][j - len]
                        + pre[i - len][j - len];
                if (sum <= threshold)
                    return true;
            }
        }
        return false;
    }
}