public class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int x : nums) res ^= x;
        return res;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.singleNumber(new int[]{2,2,1})); 
        System.out.println(s.singleNumber(new int[]{4,1,2,1,2})); 
        System.out.println(s.singleNumber(new int[]{1}));
    }
}