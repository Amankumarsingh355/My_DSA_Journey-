class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int[] count = new int[value]; 
        for (int num : nums) {
            int mod = ((num % value) + value) % value;
            count[mod]++;
        }
        int mex = 0;
        while (true) {
            int mod = mex % value;
            if (count[mod] > 0) {
                count[mod]--;
                mex++;
            } else {
                break;
            }
        }
        return mex;
    }
}