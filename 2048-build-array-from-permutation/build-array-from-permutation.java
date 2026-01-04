class Solution {
    public int[] buildArray(int[] nums) {
        int[] num = new int[nums.length];
        for(int i = 0;i<nums.length;i++){
            num[i] = nums[nums[i]];
        }
        System.gc();
        return num;
    }
}