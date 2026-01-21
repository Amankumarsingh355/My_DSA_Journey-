class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int p = nums.get(i);
            if ((p & 1) == 0) {
                ans[i] = -1;
                continue;
            }
            int s = 0;
            int temp = p;
            while ((temp & 1) == 1) {
                s++;
                temp >>= 1;
            }
            int higherBits = (p >> s) << s;
            int lowerBits = (1 << (s - 1)) - 1;
            ans[i] = higherBits | lowerBits;
        }
        return ans;
    }
}