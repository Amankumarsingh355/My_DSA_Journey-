public class Solution {
    private static class TrieNode {
        TrieNode[] child = new TrieNode[26];
        String word = null;
    }
    private TrieNode root = new TrieNode();
    private int rows, cols;
    private char[][] board;
    private final int[] dr = {-1, 1, 0, 0};
    private final int[] dc = {0, 0, -1, 1};
    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        rows = board.length;
        cols = rows == 0 ? 0 : board[0].length;
        buildTrie(words);
        List<String> res = new ArrayList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int idx = board[r][c] - 'a';
                if (idx >= 0 && idx < 26 && root.child[idx] != null) {
                    dfs(r, c, root, res);
                }
            }
        }
        return res;
    }
    private void buildTrie(String[] words) {
        for (String w : words) {
            TrieNode node = root;
            for (char ch : w.toCharArray()) {
                int i = ch - 'a';
                if (node.child[i] == null) node.child[i] = new TrieNode();
                node = node.child[i];
            }
            node.word = w;
        }
    }
    private void dfs(int r, int c, TrieNode parent, List<String> res) {
        char ch = board[r][c];
        int idx = ch - 'a';
        TrieNode node = parent.child[idx];
        if (node == null) return;
        if (node.word != null) {
            res.add(node.word);
            node.word = null;
        }
        board[r][c] = '#';
        for (int k = 0; k < 4; k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];
            if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;
            char next = board[nr][nc];
            if (next == '#') continue;
            int nextIdx = next - 'a';
            if (nextIdx < 0 || nextIdx >= 26) continue;
            if (node.child[nextIdx] != null) dfs(nr, nc, node, res);
        }
        board[r][c] = ch;
        if (isEmpty(node)) {
            parent.child[idx] = null;
        }
    }
    private boolean isEmpty(TrieNode node) {
        if (node == null) return true;
        if (node.word != null) return false;
        for (TrieNode ch : node.child) if (ch != null) return false;
        return true;
    }
}