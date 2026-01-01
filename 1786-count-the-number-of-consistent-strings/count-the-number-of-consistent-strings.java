class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] allow = new boolean[26];
        int count = 0;
        for (int i = 0; i < allowed.length(); i++) {
            allow[allowed.charAt(i) - 'a'] = true;
        }
        label: for (String w : words) {
            for (int i = 0; i < w.length(); i++) {
                if (!allow[w.charAt(i) - 'a']) {
                    continue label;
                }
            }
            count++;
        }
        return count;
    }
}