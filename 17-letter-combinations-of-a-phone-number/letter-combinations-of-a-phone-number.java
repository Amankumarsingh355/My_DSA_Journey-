public class Solution {
    private static final String[] MAP = {
        "",    
        "",  
        "abc",
        "def", 
        "ghi", 
        "jkl", 
        "mno", 
        "pqrs",
        "tuv",
        "wxyz" 
    };
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;
        backtrack(digits, 0, new StringBuilder(), res);
        return res;
    }
    private void backtrack(String digits, int idx, StringBuilder cur, List<String> res) {
        if (idx == digits.length()) {
            res.add(cur.toString());
            return;
        }
        char c = digits.charAt(idx);
        if (c < '0' || c > '9') return;
        String letters = MAP[c - '0'];
        if (letters.isEmpty()) {
            backtrack(digits, idx + 1, cur, res);
            return;
        }
        for (char ch : letters.toCharArray()) {
            cur.append(ch);
            backtrack(digits, idx + 1, cur, res);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}