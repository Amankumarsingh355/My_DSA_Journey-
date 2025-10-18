class Solution {
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }
    private int dfs(TreeNode node, int maxSoFar) {
        if (node == null) return 0;
        int good = node.val >= maxSoFar ? 1 : 0;
        maxSoFar = Math.max(maxSoFar, node.val);
        return good + dfs(node.left, maxSoFar) + dfs(node.right, maxSoFar);
    }
}