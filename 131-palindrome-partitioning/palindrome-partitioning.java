public class Solution {
    public List<List<String>> partition(String s) {
        int n = s.length();
        boolean[][] isPal = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || isPal[i + 1][j - 1])) {
                    isPal[i][j] = true;
                }
            }
        }
        List<List<String>> res = new ArrayList<>();
        LinkedList<String> cur = new LinkedList<>();
        backtrack(0, s, isPal, cur, res);
        return res;
    }
    private void backtrack(int start, String s, boolean[][] isPal,
                           LinkedList<String> cur, List<List<String>> res) {
        int n = s.length();
        if (start == n) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int end = start; end < n; end++) {
            if (!isPal[start][end]) continue;
            cur.addLast(s.substring(start, end + 1));
            backtrack(end + 1, s, isPal, cur, res);
            cur.removeLast();
        }
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.partition("aab")); 
        System.out.println(sol.partition("a"));   
    }
}