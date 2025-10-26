class Solution {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return sum;
    }
    void helper(TreeNode node, int path) {
        if (node == null) return;
        path = path * 10 + node.val;
        if (node.left == null && node.right == null) {
            sum += path;
        }
        helper(node.left, path);
        helper(node.right, path);
    }
}