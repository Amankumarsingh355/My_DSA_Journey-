public class Solution {
    private int best = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        best = Integer.MIN_VALUE;
        dfs(root);
        return best;
    }
    private int dfs(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(0, dfs(node.left));
        int right = Math.max(0, dfs(node.right));
        int through = node.val + left + right;
        best = Math.max(best, through);
        return node.val + Math.max(left, right);
    }
}