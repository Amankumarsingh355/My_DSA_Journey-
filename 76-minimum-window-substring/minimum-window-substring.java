public class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0) return "";
        Map<Character, Integer> targetFreq = new HashMap<>();
        for (char c : t.toCharArray())
            targetFreq.put(c, targetFreq.getOrDefault(c, 0) + 1);
        Map<Character, Integer> windowFreq = new HashMap<>();
        int required = targetFreq.size();
        int formed = 0;
        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE, minStart = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            windowFreq.put(c, windowFreq.getOrDefault(c, 0) + 1);
            if (targetFreq.containsKey(c) && windowFreq.get(c).intValue() == targetFreq.get(c).intValue())
                formed++;
            while (left <= right && formed == required) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }
                char d = s.charAt(left);
                windowFreq.put(d, windowFreq.get(d) - 1);
                if (targetFreq.containsKey(d) && windowFreq.get(d).intValue() < targetFreq.get(d).intValue())
                    formed--;
                left++;
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}