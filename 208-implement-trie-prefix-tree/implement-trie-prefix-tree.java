public class Trie {
    private static class Node {
        Node[] next = new Node[26];
        boolean isEnd;
    }
    private final Node root;
    public Trie() {
        root = new Node();
    }
    public void insert(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (cur.next[idx] == null) cur.next[idx] = new Node();
            cur = cur.next[idx];
        }
        cur.isEnd = true;
    }
    public boolean search(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (cur.next[idx] == null) return false;
            cur = cur.next[idx];
        }
        return cur.isEnd;
    }
    public boolean startsWith(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            if (cur.next[idx] == null) return false;
            cur = cur.next[idx];
        }
        return true;
    }
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app")); 
        trie.insert("app");
        System.out.println(trie.search("app"));
    }
}