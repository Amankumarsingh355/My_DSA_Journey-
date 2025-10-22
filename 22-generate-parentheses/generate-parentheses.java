public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0) return res;
        backtrack(new StringBuilder(), 0, 0, n, res);
        return res;
    }
    private void backtrack(StringBuilder cur, int open, int close, int n, List<String> res) {
        if (cur.length() == 2 * n) {
            res.add(cur.toString());
            return;
        }
        if (open < n) {
            cur.append('(');
            backtrack(cur, open + 1, close, n, res);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(')');
            backtrack(cur, open, close + 1, n, res);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.generateParenthesis(3));
    }
}