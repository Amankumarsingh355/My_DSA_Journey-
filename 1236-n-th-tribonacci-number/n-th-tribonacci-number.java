public class Solution {
    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        int a = 0, b = 1, c = 1;
        for (int i = 3; i <= n; ++i) {
            int d = a + b + c;
            a = b;
            b = c;
            c = d;
        }
        return c;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.tribonacci(4));  
        System.out.println(s.tribonacci(25));
    }
}