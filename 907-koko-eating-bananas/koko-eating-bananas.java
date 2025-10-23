public class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int p : piles) max = Math.max(max, p);
        int lo = 1, hi = max;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (canFinish(piles, h, mid)) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
    private boolean canFinish(int[] piles, int h, int k) {
        long hours = 0;
        for (int p : piles) {
            hours += (p + k - 1L) / k;
            if (hours > h) return false;
        }
        return hours <= h;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minEatingSpeed(new int[] {3,6,7,11}, 8));
        System.out.println(s.minEatingSpeed(new int[] {30,11,23,4,20}, 5));
        System.out.println(s.minEatingSpeed(new int[] {30,11,23,4,20}, 6));
    }
}