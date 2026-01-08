class Solution {
    public int countWords(String[] words1, String[] words2) {
        int n1 = words1.length, n2 = words2.length;
        int ans = 0;
        ArrayList<String> word = new ArrayList<>();
        for (int i = 0; i < n1; i++) {
            int t = 0;
            for (int j = 0; j < n1; j++) {
                if (i != j && !words1[i].equals(words1[j])) t++;
            }
            if (t == n1 - 1) word.add(words1[i]);
        }
        n1 = word.size();
        for (int i = 0; i < n1; i++) {
            int t = 0;
            for (int j = 0; j < n2; j++) {
                if (word.get(i).equals(words2[j])) t++;
                if (t > 1) break;
            }
            if (t == 1) ans++;
        }
        return ans;
    }
}