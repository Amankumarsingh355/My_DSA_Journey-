class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        if (target.length != arr.length) {
            return false;
        }
        int[] count = new int[1001];
        for (int num : target) {
            count[num]++;
        }
        for (int num : arr) {
            if (--count[num] < 0) {
                return false;
            }
        }
        return true;
    }
}