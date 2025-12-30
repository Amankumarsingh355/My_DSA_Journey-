class Solution {
    public int[] runningSum(int[] nums) {
        int sums = 0;
        int[] retSums = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            sums += nums[i];
            retSums[i] = sums;
        }
        return retSums;
    }
}