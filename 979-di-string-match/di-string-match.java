class Solution {
    public int[] diStringMatch(String s) {
        char[] chars = s.toCharArray();
        int min = 0;
        int len = chars.length;
        int max = len;
        int[] rez = new int[len + 1];
        for (int i = 0; i < len; i++) {
            if (chars[i] == 'I') {
                rez[i] = min++;
            } else {
                rez[i] = max--;
            }
        }
        rez[len] = min;
        return rez;
    }
}