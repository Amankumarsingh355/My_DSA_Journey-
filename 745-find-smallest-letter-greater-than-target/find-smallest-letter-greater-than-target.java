class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int[] freq = new int[26];
        for (int i = 0; i < letters.length; i++)
            freq[letters[i] - 'a']++;
        int th = target - 'a';
        for (int i = 0; i < freq.length; i++)
            if (i > th && freq[i] != 0)
                return (char) (i + 'a');
        return letters[0];
    }
}