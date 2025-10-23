public class Solution {
    public int searchInsert(int[] nums, int target) {
        int lo = 0, hi = nums.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < target) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.searchInsert(new int[]{1,3,5,6}, 5)); 
        System.out.println(s.searchInsert(new int[]{1,3,5,6}, 2)); 
        System.out.println(s.searchInsert(new int[]{1,3,5,6}, 7));
    }
}