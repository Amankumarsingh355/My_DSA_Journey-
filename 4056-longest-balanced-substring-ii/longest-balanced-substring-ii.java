class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        if (n == 0) return 0;
        int maxRun = 1;
        int run = 1;
        for (int i = 1; i < n; ++i) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                run++;
            } else {
                maxRun = Math.max(maxRun, run);
                run = 1;
            }
        }
        maxRun = Math.max(maxRun, run);
        int ans = Math.max(1, maxRun); 
        {
            int a = 0, b = 0, c = 0;
            Map<String, Integer> map = new HashMap<>();
            map.put("0,0", -1);
            for (int i = 0; i < n; ++i) {
                char ch = s.charAt(i);
                if (ch == 'a') a++;
                else if (ch == 'b') b++;
                else c++;
                String key = (a - b) + "," + (a - c);
                if (map.containsKey(key)) {
                    ans = Math.max(ans, i - map.get(key));
                } else {
                    map.put(key, i);
                }
            }
        }
        ans = Math.max(ans, longestForPair(s, 'a', 'b', 'c'));
        ans = Math.max(ans, longestForPair(s, 'a', 'c', 'b'));
        ans = Math.max(ans, longestForPair(s, 'b', 'c', 'a'));
        return ans;
    }
    private int longestForPair(String s, char x, char y, char sep) {
        int n = s.length();
        int best = 0;
        int i = 0;
        while (i < n) {
            while (i < n && s.charAt(i) == sep) i++;
            if (i >= n) break;
            int start = i;
            while (i < n && s.charAt(i) != sep) i++;
            int end = i - 1;
            best = Math.max(best, longestEqualTwoCharsInRange(s, start, end, x, y));
        }
        return best;
    }
    private int longestEqualTwoCharsInRange(String s, int start, int end, char x, char y) {
        Map<Integer, Integer> map = new HashMap<>();
        int diff = 0;
        map.put(0, start - 1);
        int best = 0;
        for (int i = start; i <= end; ++i) {
            char ch = s.charAt(i);
            if (ch == x) diff++;
            else if (ch == y) diff--;
            if (map.containsKey(diff)) {
                best = Math.max(best, i - map.get(diff));
            } else {
                map.put(diff, i);
            }
        }
        return best;
    }
}