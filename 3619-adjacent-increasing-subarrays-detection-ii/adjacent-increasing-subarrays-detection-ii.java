public class Solution {
    public int maxIncreasingSubarrays(List<Integer> arr) {
        int ans = 0, pre = 0, cur = 1, len = arr.size();
        for (int idx = 1; idx <= len; idx++) {
            if (idx < len && arr.get(idx) > arr.get(idx - 1)) {
                cur++;
            } else {
                ans = Math.max(ans, Math.max(cur / 2, Math.min(pre, cur)));
                pre = cur;
                cur = 1;
            }
        }
        return ans;
    }
}