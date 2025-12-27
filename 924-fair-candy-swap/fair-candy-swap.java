class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int sumA = 0, sumB = 0;
        for (int a : aliceSizes) sumA += a;
        for (int b : bobSizes) sumB += b;
        int diff = (sumB - sumA) / 2;
        Set<Integer> exchange = new HashSet<>();
        for (int b : bobSizes) exchange.add(b);
        for (int a : aliceSizes) {
            int b = a + diff;
            if (exchange.contains(b)) {
                return new int[]{a, b};
            }
        }
        return new int [0];
    }
}