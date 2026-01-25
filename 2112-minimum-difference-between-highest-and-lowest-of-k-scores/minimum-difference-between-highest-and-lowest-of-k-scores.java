class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        k--;
        for(int i = 0; k < nums.length; i++,k++){
            int diff = nums[k] - nums[i];
            if(diff < minDiff)
                minDiff = diff;
        }
        return minDiff;
    }
}