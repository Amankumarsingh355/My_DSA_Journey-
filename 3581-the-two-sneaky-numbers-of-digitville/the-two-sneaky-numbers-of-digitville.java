class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int n = nums.length - 2;
        cycle(nums, n);
        cycle(nums, n+1);
        return new int[] { nums[n], nums[n+1] };
    }
    private void cycle(int[] nums, int n) {
        while (nums[n] != nums[nums[n]]) {
            int tmp = nums[n];
            nums[n] = nums[tmp];
            nums[tmp] = tmp;
        }
    }
}