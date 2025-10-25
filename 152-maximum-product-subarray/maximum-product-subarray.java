class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int curMax = nums[0], curMin = nums[0], ans = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] < 0) {
                int temp = curMax;
                curMax = curMin;
                curMin = temp;
            }
            curMax = Math.max(nums[i], curMax * nums[i]);
            curMin = Math.min(nums[i], curMin * nums[i]);
            ans = Math.max(ans, curMax);
        }
        return ans;
    }
}
