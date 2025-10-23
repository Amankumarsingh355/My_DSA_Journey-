public class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        int prev2 = nums[0];     
        int prev1 = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; ++i) {
            int cur = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = cur;
        }
        return prev1;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.rob(new int[] {1,2,3,1})); 
        System.out.println(s.rob(new int[] {2,7,9,3,1}));
    }
}