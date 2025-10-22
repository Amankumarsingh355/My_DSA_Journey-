public class Solution {
    private static class Pair {
        int cost;
        int idx;
        Pair(int cost, int idx) { this.cost = cost; this.idx = idx; }
    }
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        PriorityQueue<Pair> leftHeap = new PriorityQueue<>((a, b) -> {
            if (a.cost != b.cost) return Integer.compare(a.cost, b.cost);
            return Integer.compare(a.idx, b.idx);
        });
        PriorityQueue<Pair> rightHeap = new PriorityQueue<>((a, b) -> {
            if (a.cost != b.cost) return Integer.compare(a.cost, b.cost);
            return Integer.compare(a.idx, b.idx);
        });
        int l = 0, r = n - 1;
        for (int i = 0; i < candidates && l <= r; i++) {
            leftHeap.offer(new Pair(costs[l], l));
            l++;
        }
        for (int i = 0; i < candidates && l <= r; i++) {
            rightHeap.offer(new Pair(costs[r], r));
            r--;
        }
        long total = 0;
        for (int hire = 0; hire < k; hire++) {
            boolean takeLeft;
            if (leftHeap.isEmpty()) {
                takeLeft = false;
            } else if (rightHeap.isEmpty()) {
                takeLeft = true;
            } else {
                Pair L = leftHeap.peek();
                Pair R = rightHeap.peek();
                if (L.cost != R.cost) takeLeft = L.cost < R.cost;
                else takeLeft = L.idx < R.idx;
            }
            if (takeLeft) {
                Pair p = leftHeap.poll();
                total += p.cost;
                if (l <= r) {
                    leftHeap.offer(new Pair(costs[l], l));
                    l++;
                }
            } else {
                Pair p = rightHeap.poll();
                total += p.cost;
                if (l <= r) {
                    rightHeap.offer(new Pair(costs[r], r));
                    r--;
                }
            }
        }
        return total;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.totalCost(new int[]{17,12,10,2,7,2,11,20,8}, 3, 4));
        System.out.println(s.totalCost(new int[]{1,2,4,1}, 3, 3));
    }
}