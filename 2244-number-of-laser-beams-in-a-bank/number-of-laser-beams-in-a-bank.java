class Solution {
    public int numberOfBeams(String[] bank) {
        int prev = 0;
        int ans = 0;
        for (String row : bank) {
            int cur = 0;
            for (int i = 0; i < row.length(); ++i) {
                if (row.charAt(i) == '1') cur++;
            }
            if (cur > 0) {
                ans += prev * cur;
                prev = cur;
            }
        }
        return ans;
    }
}