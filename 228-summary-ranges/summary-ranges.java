public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        int start = nums[0];
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int x = nums[i];
            if (x == prev + 1) {
                prev = x;
            } else {
                if (start == prev) res.add(String.valueOf(start));
                else res.add(start + "->" + prev);
                start = prev = x;
            }
        }
        if (start == prev) res.add(String.valueOf(start));
        else res.add(start + "->" + prev);
        return res;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.summaryRanges(new int[]{0,1,2,4,5,7}));
        System.out.println(s.summaryRanges(new int[]{0,2,3,4,6,8,9}));
        System.out.println(s.summaryRanges(new int[]{}));
    }
}