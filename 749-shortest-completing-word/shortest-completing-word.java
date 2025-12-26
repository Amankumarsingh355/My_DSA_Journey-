class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] expectedLetters = countLetters(licensePlate);
        String best = null;
        for (String word : words) {
            int[] wordLetters = countLetters(word);
            if (checkWord(expectedLetters, wordLetters) && (best == null || best.length() > word.length())) {
                best = word;
            }
        }
        return best;
    }
    private int[] countLetters(String s) {
        int[] arr = new int[26];
        for (char ch : s.toCharArray()) {
            if (Character.isLetter(ch)) {
                arr[Character.toLowerCase(ch) - 'a']++;
            }
        }
        return arr;
    }
    private boolean checkWord(int[] expected, int[] current) {
        for (int i = 0; i < 26; i++) {
            if (current[i] < expected[i]) {
                return false;
            }
        }
        return true;
    }
}