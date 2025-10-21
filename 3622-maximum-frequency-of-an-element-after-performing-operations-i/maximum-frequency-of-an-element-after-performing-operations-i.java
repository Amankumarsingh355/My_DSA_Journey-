class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Arrays.sort(nums);
        int n = nums.length;
        if (n == 0) return 0;
        ArrayList<Integer> uniq = new ArrayList<>();
        uniq.add(nums[0]);
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i-1]) uniq.add(nums[i]);
        }
        int ans = 1;
        for (int val : uniq) {
            int left = lowerBound(nums, val - k);
            int right = upperBound(nums, val + k) - 1;
            int countCover = (right >= left) ? (right - left + 1) : 0;
            int firstEq = lowerBound(nums, val);
            int lastEq = upperBound(nums, val) - 1;
            int countFixed = (lastEq >= firstEq) ? (lastEq - firstEq + 1) : 0;
            int achievable = countFixed + Math.min(numOperations, countCover - countFixed);
            ans = Math.max(ans, achievable);
        }
        int l = 0;
        int maxCover = 0;
        for (int r = 0; r < n; r++) {
            while (l <= r && nums[r] - nums[l] > 2L * k) l++;
            maxCover = Math.max(maxCover, r - l + 1);
        }
        ans = Math.max(ans, Math.min(numOperations, maxCover));
        return Math.min(ans, n);
    }
    private int lowerBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (arr[m] < target) l = m + 1;
            else r = m;
        }
        return l;
    }
    private int upperBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (arr[m] <= target) l = m + 1;
            else r = m;
        }
        return l;
    }
}