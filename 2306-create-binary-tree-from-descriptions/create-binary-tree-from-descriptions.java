class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> nodes = new HashMap<>();      
        Set<Integer> children = new HashSet<>();
        for (int[] d : descriptions) {
            int parent = d[0];
            int child = d[1];
            int isLeft = d[2];
            nodes.putIfAbsent(parent, new TreeNode(parent));
            nodes.putIfAbsent(child, new TreeNode(child));
            if (isLeft == 1)
                nodes.get(parent).left = nodes.get(child);
            else
                nodes.get(parent).right = nodes.get(child);
            children.add(child);
        }
        for (int value : nodes.keySet()) {
            if (!children.contains(value))
                return nodes.get(value);
        }
        return null;
    }
}