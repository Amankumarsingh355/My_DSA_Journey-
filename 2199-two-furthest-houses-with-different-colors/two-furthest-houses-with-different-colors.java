class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int result = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (colors[i] != colors[0]) {
                result = Math.max(result, i);
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            if (colors[i] != colors[n - 1]) {
                result = Math.max(result, (n - 1) - i);
                break;
            }
        }
        return result;
    }
}