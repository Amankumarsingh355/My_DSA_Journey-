public class Solution {
    public int minFlips(int a, int b, int c) {
        int flips = 0;
        while (a > 0 || b > 0 || c > 0) {
            int abit = a & 1;
            int bbit = b & 1;
            int cbit = c & 1;
            if (cbit == 1) {
                if (abit == 0 && bbit == 0) flips += 1;
            } else {
                if (abit == 1 && bbit == 1) flips += 2;
                else if (abit == 1 || bbit == 1) flips += 1;
            }
            a >>= 1;
            b >>= 1;
            c >>= 1;
        }
        return flips;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minFlips(2, 6, 5)); 
        System.out.println(s.minFlips(4, 2, 7));
        System.out.println(s.minFlips(1, 2, 3)); 
    }
}