class Solution {
    public int numberOfSpecialChars(String word) {
        int cnt = 0;
        HashSet<Character> lower = new HashSet<>();
        HashSet<Character> upper = new HashSet<>();
        for (char ch : word.toCharArray()) {
            if (Character.isLowerCase(ch))
                lower.add(ch);
            else
                upper.add(Character.toLowerCase(ch));
        }
        for (char ch : lower) {
            if (upper.contains(ch))
                cnt++;
        }
        return cnt;
    }
}