class Solution {
    public int ladderLength(String st, String tar, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(tar)) return 0; 
        Queue<Pair<String, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(st, 1));
        while (!q.isEmpty()) {
            String word = q.peek().getKey();
            int steps = q.peek().getValue();
            q.poll();
            if (word.equals(tar)) return steps;
            char[] arr = word.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                char original = arr[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    arr[i] = c;
                    String newWord = new String(arr);
                    if (dict.contains(newWord)) {
                        dict.remove(newWord);
                        q.add(new Pair<>(newWord, steps + 1));
                    }
                }
                arr[i] = original;
            }
        }
        return 0;
    }
}
