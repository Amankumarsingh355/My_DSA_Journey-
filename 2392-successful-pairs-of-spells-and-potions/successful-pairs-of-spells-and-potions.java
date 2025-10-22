class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length, m = potions.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            long spell = spells[i];
            long minPotion = (success + spell - 1) / spell;
            int idx = lowerBound(potions, minPotion);
            res[i] = m - idx;
        }
        return res;
    }

    private int lowerBound(int[] potions, long target) {
        int left = 0, right = potions.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (potions[mid] < target) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}
