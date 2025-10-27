class MedianFinder {
    private PriorityQueue<Integer> lowers;
    private PriorityQueue<Integer> highers;
    public MedianFinder() {
        lowers = new PriorityQueue<>(Collections.reverseOrder());
        highers = new PriorityQueue<>();
    }
    public void addNum(int num) {
        if (lowers.isEmpty() || num <= lowers.peek()) {
            lowers.offer(num);
        } else {
            highers.offer(num);
        }
        if (lowers.size() > highers.size() + 1) {
            highers.offer(lowers.poll());
        } else if (highers.size() > lowers.size()) {
            lowers.offer(highers.poll());
        }
    }
    public double findMedian() {
        if (lowers.size() > highers.size()) {
            return lowers.peek();
        } else {
            return (lowers.peek() + highers.peek()) / 2.0;
        }
    }
}