class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        int[] diff = new int[52];
        for (int[] seg : ranges) {
            diff[seg[0]]++;
            diff[seg[1] + 1]--;
        }
        int cover = 0;
        for (int x = 1; x <= 50; x++) {
            cover += diff[x];
            if (x >= left && x <= right && cover == 0) return false;
            if (x == right) return true;
        }
        return true;
    }
}