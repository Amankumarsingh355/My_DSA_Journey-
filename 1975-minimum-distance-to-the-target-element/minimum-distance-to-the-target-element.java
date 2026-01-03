class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int n = nums.length;
        int minAbs = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (nums[i] == target) {
                int currAbsVal = Math.abs(i - start);
                if (currAbsVal < minAbs) {
                    minAbs = currAbsVal;
                }
            }
        }
        return minAbs;
    }
}