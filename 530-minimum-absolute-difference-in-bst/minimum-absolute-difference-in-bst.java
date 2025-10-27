class Solution {
    private Integer prev = null;
    private int best = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return best;
    }
    private void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        if (prev != null) {
            best = Math.min(best, node.val - prev);
        }
        prev = node.val;
        inorder(node.right);
    }
}