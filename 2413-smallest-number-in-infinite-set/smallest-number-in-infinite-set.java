public class SmallestInfiniteSet {
    private PriorityQueue<Integer> pq;
    private HashSet<Integer> inHeap;
    private int cur;
    public SmallestInfiniteSet() {
        pq = new PriorityQueue<>();
        inHeap = new HashSet<>();
        cur = 1;
    }
    public int popSmallest() {
        if (!pq.isEmpty()) {
            int val = pq.poll();
            inHeap.remove(val);
            return val;
        }
        return cur++;
    }
    public void addBack(int num) {
        if (num < cur && !inHeap.contains(num)) {
            pq.offer(num);
            inHeap.add(num);
        }
    }
}