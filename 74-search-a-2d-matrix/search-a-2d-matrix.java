public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int lo = 0, hi = m * n - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int r = mid / n;
            int c = mid % n;
            int val = matrix[r][c];
            if (val == target) return true;
            if (val < target) lo = mid + 1;
            else hi = mid - 1;
        }
        return false;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] a = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(s.searchMatrix(a, 3)); 
        System.out.println(s.searchMatrix(a, 13));
    }
}