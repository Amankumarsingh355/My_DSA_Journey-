public class Solution {
    public static class Node {
        int val;
        Node left;
        Node right;
        Node(int v) { val = v; }
        Node(int v, Node l, Node r) { val = v; left = l; right = r; }
    }
    public Node transformTree(Node root) {
        transform(root);
        return root;
    }
    private void transform(Node root) {
        if (root == null) return;
        Node tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        transform(root.left);
        transform(root.right);
    }
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int[] last = new int[256];
        Arrays.fill(last, 0);
        int maxLen = 0;
        int left = 0;
        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);
            left = Math.max(left, last[c]);
            maxLen = Math.max(maxLen, right - left + 1);
            last[c] = right + 1;
        }
        return maxLen;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.lengthOfLongestSubstring("abcabcbb"));
        Node root = new Node(1, new Node(2), new Node(3));
        sol.transformTree(root);
        System.out.println(root.left.val + " " + root.right.val);
    }
}