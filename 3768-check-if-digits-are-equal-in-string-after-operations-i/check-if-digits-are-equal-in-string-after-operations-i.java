public class Solution {
    public boolean hasSameDigits(String s) {
        String cur = s;
        while (cur.length() > 2) {
            StringBuilder sb = new StringBuilder(cur.length() - 1);
            for (int i = 0; i + 1 < cur.length(); ++i) {
                int a = cur.charAt(i) - '0';
                int b = cur.charAt(i + 1) - '0';
                sb.append((a + b) % 10);
            }
            cur = sb.toString();
        }
        return cur.charAt(0) == cur.charAt(1);
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.hasSameDigits("3902")); 
        System.out.println(sol.hasSameDigits("34789"));
    }
}