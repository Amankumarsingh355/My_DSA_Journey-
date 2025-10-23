class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.addLast(root);
        while (!q.isEmpty()) {
            int sz = q.size();
            List<Integer> level = new ArrayList<>(sz);
            for (int i = 0; i < sz; ++i) {
                TreeNode node = q.removeFirst();
                level.add(node.val);
                if (node.left != null) q.addLast(node.left);
                if (node.right != null) q.addLast(node.right);
            }
            ans.add(level);
        }
        return ans;
    }
}