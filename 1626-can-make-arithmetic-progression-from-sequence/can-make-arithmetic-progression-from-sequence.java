class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        int len = arr.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }
        if (max == min) {
            return true;
        }
        int diff = max - min;
        if (diff % (len - 1) != 0) {
            return false;
        }
        int step = diff / (len - 1);
        boolean[] seen = new boolean[len];
        for (int num : arr) {
            int pos = (num - min) / step;
            if ((num - min) % step != 0) {
                return false;
            }
            if (seen[pos]) {
                return false;
            }
            seen[pos] = true;
        }
        return true;
    }
}