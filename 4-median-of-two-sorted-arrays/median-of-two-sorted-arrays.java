public class Solution {
    public double findMedianSortedArrays(int[] A, int[] B) {
        if (A.length > B.length) return findMedianSortedArrays(B, A);
        int m = A.length, n = B.length;
        int low = 0, high = m;
        while (low <= high) {
            int i = (low + high) >>> 1;           
            int j = (m + n + 1) / 2 - i; 
            int Aleft  = (i == 0) ? Integer.MIN_VALUE : A[i - 1];
            int Aright = (i == m) ? Integer.MAX_VALUE : A[i];
            int Bleft  = (j == 0) ? Integer.MIN_VALUE : B[j - 1];
            int Bright = (j == n) ? Integer.MAX_VALUE : B[j];
            if (Aleft <= Bright && Bleft <= Aright) {
                if (((m + n) & 1) == 1) {
                    return (double)Math.max(Aleft, Bleft);
                } else {
                    int leftMax = Math.max(Aleft, Bleft);
                    int rightMin = Math.min(Aright, Bright);
                    return (leftMax + rightMin) / 2.0;
                }
            } else if (Aleft > Bright) {
                high = i - 1;
            } else {
                low = i + 1;
            }
        }
        throw new IllegalArgumentException("Input arrays not valid");
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findMedianSortedArrays(new int[]{1,3}, new int[]{2}));     
        System.out.println(s.findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}));   
        System.out.println(s.findMedianSortedArrays(new int[]{}, new int[]{1}));
    }
}