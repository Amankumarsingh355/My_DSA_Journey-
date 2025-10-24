public class Solution {
    public int uniquePaths(int m, int n) {
        int N = m + n - 2;
        int k = Math.min(m - 1, n - 1);
        long res = 1L;
        for (int i = 1; i <= k; i++) {
            res = res * (N - k + i) / i;
        }
        return (int) res;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.uniquePaths(3, 7)); 
        System.out.println(s.uniquePaths(3, 2));
        System.out.println(s.uniquePaths(1, 1));
    }
}