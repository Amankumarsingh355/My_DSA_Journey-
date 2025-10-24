public class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i & (i - 1)] + 1;
        }
        return ans;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(java.util.Arrays.toString(s.countBits(2)));
        System.out.println(java.util.Arrays.toString(s.countBits(5)));
        System.out.println(java.util.Arrays.toString(s.countBits(0)));
    }
}