class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int start = 0; start < n; ++start) {
            if (nums[start] != 0) continue;
            if (simulate(nums, start, 1)) ans++;
            if (simulate(nums, start, -1)) ans++;
        }
        return ans;
    }
    private boolean simulate(int[] nums, int start, int dir) {
        int n = nums.length;
        int[] a = nums.clone();
        int curr = start;
        int d = dir;
        while (curr >= 0 && curr < n) {
            if (a[curr] == 0) {
                curr += d;
            } else {
                a[curr]--;
                d = -d;
                curr += d;
            }
        }
        for (int v : a) if (v != 0) return false;
        return true;
    }
}