public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> lastIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer prev = lastIndex.get(nums[i]);
            if (prev != null && i - prev <= k) return true;
            lastIndex.put(nums[i], i);
        }
        return false;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.containsNearbyDuplicate(new int[]{1,2,3,1}, 3)); // true
        System.out.println(s.containsNearbyDuplicate(new int[]{1,0,1,1}, 1)); // true
        System.out.println(s.containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2)); // false
    }
}