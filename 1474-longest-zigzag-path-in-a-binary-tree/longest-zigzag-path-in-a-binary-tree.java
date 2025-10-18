class Solution {
    int maxLen = 0;
    public int longestZigZag(TreeNode root) {
        dfs(root, true, 0);
        dfs(root, false, 0);
        return maxLen;
    }
    private void dfs(TreeNode node, boolean isLeft, int length) {
        if (node == null) return;
        maxLen = Math.max(maxLen, length);
        if (isLeft) {
            dfs(node.left, false, length + 1);
            dfs(node.right, true, 1);
        } else {
            dfs(node.right, true, length + 1);
            dfs(node.left, false, 1);
        }
    }
}