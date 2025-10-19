class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        Queue<String> q = new LinkedList<>();
        Set<String> seen = new HashSet<>();
        String smallest = s;
        q.offer(s);
        seen.add(s);
        while (!q.isEmpty()) {
            String cur = q.poll();
            if (cur.compareTo(smallest) < 0)
                smallest = cur;
            char[] ch = cur.toCharArray();
            for (int i = 1; i < ch.length; i += 2) {
                int newDigit = (ch[i] - '0' + a) % 10;
                ch[i] = (char) ('0' + newDigit);
            }
            String added = new String(ch);
            if (!seen.contains(added)) {
                seen.add(added);
                q.offer(added);
            }
            String rotated = cur.substring(cur.length() - b) + cur.substring(0, cur.length() - b);
            if (!seen.contains(rotated)) {
                seen.add(rotated);
                q.offer(rotated);
            }
        }
        return smallest;
    }
}