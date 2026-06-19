public class Solution {
    public int largestAltitude(int[] gain) {
        int cur = 0, max = 0;
        for (int g : gain) {
            cur += g;
            if (cur > max) max = cur;
        }
        return max;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.largestAltitude(new int[]{-5,1,5,0,-7})); // 1
        System.out.println(s.largestAltitude(new int[]{-4,-3,-2,-1,4,3,2})); // 0
    }
}