class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int a = 1;
        int b = 2;
        for (int i = 3; i <= n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.climbStairs(2));
        System.out.println(s.climbStairs(3));
        System.out.println(s.climbStairs(45));
    }
}