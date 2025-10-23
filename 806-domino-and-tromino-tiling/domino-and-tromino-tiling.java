public class Solution{
    private static final int MOD = 1_000_000_007;
    public int numTilings(int n){
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;
        long d0 = 1; 
        long d1 = 1;
        long d2 = 2;
        for (int i = 3; i <= n; ++i){
            long cur = (2 * d2 + d0) % MOD;
            d0 = d1;
            d1 = d2;
            d2 = cur;
        }
        return (int)d2;
    }
    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.numTilings(3)); 
        System.out.println(s.numTilings(1));
    }
}