class Solution {
    public int totalMoney(int n) {
        int w = n / 7;
        int r = n % 7;
        int fullWeeks = 28 * w + 7 * w * (w - 1) / 2;
        int rem = r * (1 + w) + r * (r - 1) / 2;
        return fullWeeks + rem;
    }
}