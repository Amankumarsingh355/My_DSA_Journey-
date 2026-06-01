class Solution {
    public int minimumCost(int[] cost) {
        int totalCost = 0;
        Arrays.sort(cost);
        int l = cost.length;
        int numThree = l / 3;
        int modThree = l % 3;
        int pos = l - 1;
        for (int i = 0; i < numThree; i++) {
            int firstCandy = cost[pos];
            totalCost = totalCost + firstCandy;
            pos--;
            int secondCandy = cost[pos];
            totalCost = totalCost + secondCandy;
            pos -= 2;
        }
        for (int i = 0; i < modThree; i++) {
            int candy = cost[pos];
            totalCost = totalCost + candy;
            pos--;
        }
        return totalCost;        
    }
}