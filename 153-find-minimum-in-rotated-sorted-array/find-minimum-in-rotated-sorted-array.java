public class Solution {
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[hi]) lo = mid + 1;
            else hi = mid;
        }
        return nums[lo];
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findMin(new int[]{3,4,5,1,2}));
        System.out.println(s.findMin(new int[]{4,5,6,7,0,1,2}));
        System.out.println(s.findMin(new int[]{11,13,15,17}));
    }
}