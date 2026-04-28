class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> nums = new ArrayList<>();

        for (int[] row : grid) {
            for (int val : row) {
                nums.add(val);
            }
        }

        int rem = nums.get(0) % x;
        for (int num : nums) {
            if (num % x != rem) return -1;
        }

        Collections.sort(nums);

        int median = nums.get(nums.size() / 2);

        int ops = 0;
        for (int num : nums) {
            ops += Math.abs(num - median) / x;
        }

        return ops;
    }
}