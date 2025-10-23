public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = findBound(nums, target, true);
        if (left == nums.length || left < 0 || nums[left] != target) return new int[] {-1, -1};
        int right = findBound(nums, target, false);
        return new int[] {left, right};
    }
    private int findBound(int[] nums, int target, boolean findFirst) {
        int lo = 0, hi = nums.length - 1;
        int ans = findFirst ? nums.length : -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > target) {
                hi = mid - 1;
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                if (findFirst) {
                    ans = mid;
                    hi = mid - 1;
                } else {
                    ans = mid;
                    lo = mid + 1;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.searchRange(new int[]{5,7,7,8,8,10}, 8)));
        System.out.println(Arrays.toString(s.searchRange(new int[]{5,7,7,8,8,10}, 6)));
        System.out.println(Arrays.toString(s.searchRange(new int[]{}, 0)));
    }
}