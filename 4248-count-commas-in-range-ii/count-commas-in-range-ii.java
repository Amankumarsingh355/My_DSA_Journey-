class Solution {
    public long countCommas(long n) {
        long ans = 0;
        long dig = 1000;

        while(dig <= n){
            ans += n - dig + 1;
            dig = dig * 1000;
        }
        return ans;
    }
}