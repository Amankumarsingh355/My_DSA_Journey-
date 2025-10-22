public class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) idx[i] = i;
        Arrays.sort(idx, (a, b) -> Integer.compare(nums2[b], nums2[a]));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long sum = 0;
        long ans = 0;
        for (int id : idx) {
            minHeap.offer(nums1[id]);
            sum += nums1[id];
            if (minHeap.size() > k) {
                sum -= minHeap.poll();
            }
            if (minHeap.size() == k) {
                long candidate = sum * (long) nums2[id];
                if (candidate > ans) ans = candidate;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxScore(new int[]{1,3,3,2}, new int[]{2,1,3,4}, 3)); 
        System.out.println(s.maxScore(new int[]{4,2,3,1,1}, new int[]{7,5,10,9,6}, 1));
    }
}