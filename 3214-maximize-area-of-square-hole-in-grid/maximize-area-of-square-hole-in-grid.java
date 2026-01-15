class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        return (int) Math.pow(Math.min(findMaxGap(hBars), findMaxGap(vBars)), 2);
    }
    public int findMaxGap(int[] bars) {
        Arrays.sort(bars);
        int maxConsecutive = 1;
        int currConsecutive = 1;
        int n = bars.length;
        for (int i=0; i<n-1; i++) {
            if (bars[i] + 1 == bars[i+1]) {
                currConsecutive++;
                maxConsecutive = Math.max(maxConsecutive, currConsecutive);
            } else {
                currConsecutive = 1;
            }
        }
        return maxConsecutive + 1;
    }
}