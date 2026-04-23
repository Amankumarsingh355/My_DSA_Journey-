class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] res = new long[n];
        Map<Integer, long[]> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int val = nums[i];
            if (!map.containsKey(val)) {
                map.put(val, new long[]{0, 0});
            }
            long[] data = map.get(val);
            long count = data[0];
            long sum = data[1];
            // contribution from left side
            res[i] += count * i - sum;
            data[0]++;
            data[1] += i;
        }
        map.clear();
        // Right to left pass
        for (int i = n - 1; i >= 0; i--) {
            int val = nums[i];
            if (!map.containsKey(val)) {
                map.put(val, new long[]{0, 0});
            }
            long[] data = map.get(val);
            long count = data[0];
            long sum = data[1];
            // contribution from right side
            res[i] += sum - count * i;
            data[0]++;
            data[1] += i;
        }
        return res;
    }
}