public class Solution {
    private final Random rand = new Random();
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int target = n - k;
        return quickSelect(nums, 0, n - 1, target);
    }
    private int quickSelect(int[] a, int lo, int hi, int target) {
        while (lo <= hi) {
            int pivotIndex = lo + rand.nextInt(hi - lo + 1);
            int pivot = a[pivotIndex];
            int i = lo, lt = lo, gt = hi;
            while (i <= gt) {
                if (a[i] < pivot) {
                    swap(a, lt++, i++);
                } else if (a[i] > pivot) {
                    swap(a, i, gt--);
                } else {
                    i++;
                }
            }
            if (target < lt) {
                hi = lt - 1;
            } else if (target > gt) {
                lo = gt + 1;
            } else {
                return a[lt];
            }
        }
        return -1;
    }
    private void swap(int[] a, int i, int j) {
        int t = a[i]; a[i] = a[j]; a[j] = t;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findKthLargest(new int[]{3,2,1,5,6,4}, 2)); // 5
        System.out.println(s.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4)); // 4
    }
}