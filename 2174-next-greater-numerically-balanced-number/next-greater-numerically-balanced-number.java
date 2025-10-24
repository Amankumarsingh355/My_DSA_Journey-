public class Solution {
    public int nextBeautifulNumber(int n) {
        for (int x = n + 1; x <= 1224444; x++) {
            if (isNumericallyBalanced(x)) return x;
        }
        return -1;
    }
    private boolean isNumericallyBalanced(int x) {
        int[] freq = new int[10];
        int t = x;
        while (t > 0) {
            int d = t % 10;
            if (d == 0) return false;
            freq[d]++;
            t /= 10;
        }
        for (int d = 1; d <= 9; d++) {
            if (freq[d] != 0 && freq[d] != d) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.nextBeautifulNumber(1));
        System.out.println(s.nextBeautifulNumber(1000));
        System.out.println(s.nextBeautifulNumber(3000));
    }
}