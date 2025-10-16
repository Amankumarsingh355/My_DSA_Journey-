public class Solution {
    public String decodeString(String s) {
        Deque<Integer> counts = new ArrayDeque<>();
        Deque<StringBuilder> strings = new ArrayDeque<>();
        StringBuilder current = new StringBuilder();
        int k = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0');
            } else if (ch == '[') {
                counts.push(k);
                strings.push(current);
                current = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                int repeat = counts.pop();
                StringBuilder prev = strings.pop();
                for (int i = 0; i < repeat; i++) {
                    prev.append(current);
                }
                current = prev;
            } else { 
                current.append(ch);
            }
        }
        return current.toString();
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.decodeString("3[a]2[bc]"));     
        System.out.println(sol.decodeString("3[a2[c]]"));     
        System.out.println(sol.decodeString("2[abc]3[cd]ef")); 
    }
}