class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, ans, 0);
        return ans;
    }
    private void dfs(TreeNode node, List<Integer> ans, int level) {
        if (node == null) {
            return;
        }
        if (level == ans.size()) {
            ans.add(node.val);
        }
        dfs(node.right, ans, level + 1);
        dfs(node.left, ans, level + 1);
    }
}