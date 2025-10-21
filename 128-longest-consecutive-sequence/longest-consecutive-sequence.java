public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        int best = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int curr = num;
                int len = 1;
                while (set.contains(curr + 1)) {
                    curr++;
                    len++;
                }
                best = Math.max(best, len);
            }
        }
        return best;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestConsecutive(new int[]{100,4,200,1,3,2}));
        System.out.println(s.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
        System.out.println(s.longestConsecutive(new int[]{1,0,1,2})); // 3
    }
}