class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) return s;
        int n = s.length();
        int start = 0, end = 0;
        for (int i = 0; i < n; i++) {
            int[] odd = expandAroundCenter(s, i, i);
            int[] even = expandAroundCenter(s, i, i + 1);
            if (odd[1] - odd[0] > end - start) {
                start = odd[0];
                end = odd[1];
            }
            if (even[1] - even[0] > end - start) {
                start = even[0];
                end = even[1];
            }
        }
        return s.substring(start, end + 1);
    }
    private int[] expandAroundCenter(String s, int left, int right) {
        int n = s.length();
        while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return new int[] { left + 1, right - 1 };
    }
}