class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] t = {
            ".-","-...","-.-.","-..",".","..-.","--.","....","..",
            ".---","-.-",".-..","--","-.","---",".--.","--.-",".-.",
            "...","-","..-","...-",".--","-..-","-.--","--.."
        };
        HashSet<String> set = new HashSet<>();
        for (String s : words) {
            StringBuilder temp = new StringBuilder();
            for (char c : s.toCharArray()) {
                temp.append(t[c - 'a']);
            }
            set.add(temp.toString());
        }
        return set.size();
    }
}