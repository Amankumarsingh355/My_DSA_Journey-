import java.util.*;

class Solution {

    private int maxConsecutive(int[] bars) {
        if (bars.length == 0) return 0;

        Arrays.sort(bars);
        int maxLen = 1, currLen = 1;

        for (int i = 1; i < bars.length; i++) {
            if (bars[i] == bars[i - 1] + 1)
                currLen++;
            else
                currLen = 1;

            maxLen = Math.max(maxLen, currLen);
        }
        return maxLen;
    }

    public int maximizeSquareHoleArea(int n, int m,
                                      int[] hBars, int[] vBars) {

        int maxH = maxConsecutive(hBars);
        int maxV = maxConsecutive(vBars);

        int side = Math.min(maxH + 1, maxV + 1);
        return side * side;
    }
}