class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || words == null || words.length == 0) return res;
        int wordLen = words[0].length();
        int wordCount = words.length;
        int totalLen = wordLen * wordCount;
        if (s.length() < totalLen) return res;
        Map<String, Integer> need = new HashMap<>();
        for (String w : words) need.put(w, need.getOrDefault(w, 0) + 1);
        for (int offset = 0; offset < wordLen; offset++) {
            int left = offset;
            int right = offset;
            Map<String, Integer> seen = new HashMap<>();
            int matchedWords = 0;
            while (right + wordLen <= s.length()) {
                String word = s.substring(right, right + wordLen);
                right += wordLen;
                if (!need.containsKey(word)) {
                    seen.clear();
                    matchedWords = 0;
                    left = right;
                } else {
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    matchedWords++;
                    while (seen.get(word) > need.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        seen.put(leftWord, seen.get(leftWord) - 1);
                        matchedWords--;
                        left += wordLen;
                    }
                    if (matchedWords == wordCount) {
                        res.add(left);
                        String leftWord = s.substring(left, left + wordLen);
                        seen.put(leftWord, seen.get(leftWord) - 1);
                        matchedWords--;
                        left += wordLen;
                    }
                }
            }
        }
        return res;
    }
}