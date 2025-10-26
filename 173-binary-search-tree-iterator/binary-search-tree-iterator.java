class BSTIterator {
    Stack<TreeNode> st = new Stack<>();    
    public BSTIterator(TreeNode root) {
        pushLeftChain(root);
    }
    public int next() {
        TreeNode node = st.pop();        
        if (node.right != null) {
            pushLeftChain(node.right);
        }
        return node.val;
    }
    public boolean hasNext() {
        return !st.isEmpty();
    }
    private void pushLeftChain(TreeNode node) {
        while (node != null) {
            st.push(node);
            node = node.left;
        }
    }
}