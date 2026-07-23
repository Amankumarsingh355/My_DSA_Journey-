class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if (n <=2) return n;
        int bits = 0;
        int x = n;
        while (x > 0) {
            bits++;
            x >>= 1;
        }
        return 1 << bits;
    }
}