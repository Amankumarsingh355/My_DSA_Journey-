class Solution {
    public int[] decode(int[] encoded, int first) {
        int[] rez = new int[encoded.length + 1];
        rez[0] = first;
        for (int i = 0; i < encoded.length; i++) {
            rez[i + 1] = rez[i] ^ encoded[i];
        }
        return rez;
    }
}