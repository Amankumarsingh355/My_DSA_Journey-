class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        long nextAvailable = Long.MIN_VALUE; 
        int distinct = 0;
        for (int x : nums) {
            long start = (long) x - k;
            long end = (long) x + k;
            long choose = Math.max(start, nextAvailable);
            if (choose <= end) {
                distinct++;
                nextAvailable = choose + 1;
            }
        }
        return distinct;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums1 = {1, 2, 2, 3, 3, 4};
        System.out.println(sol.maxDistinctElements(nums1, 2));
        int[] nums2 = {4, 4, 4, 4};
        System.out.println(sol.maxDistinctElements(nums2, 1)); 
        int[] nums3 = {5, 5, 5, 5, 5};
        System.out.println(sol.maxDistinctElements(nums3, 2));
    }
}