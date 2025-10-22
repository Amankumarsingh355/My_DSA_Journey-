public class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (nums[mid] == target) return mid;
            if (nums[l] <= nums[mid]) {
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.search(new int[]{4,5,6,7,0,1,2}, 0)); 
        System.out.println(s.search(new int[]{4,5,6,7,0,1,2}, 3));
        System.out.println(s.search(new int[]{1}, 0));
    }
}