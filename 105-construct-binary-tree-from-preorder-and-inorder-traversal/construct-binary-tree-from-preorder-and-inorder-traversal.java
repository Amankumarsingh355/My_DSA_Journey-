import java.util.HashMap;
import java.util.Map;
class Solution {
    private int[] preorder;
    private Map<Integer, Integer> inorderIndex;
    private int prePos;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorderIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndex.put(inorder[i], i);
        }
        prePos = 0;
        return build(0, inorder.length - 1);
    }
    private TreeNode build(int inL, int inR) {
        if (inL > inR) return null;
        int rootVal = preorder[prePos++];
        TreeNode root = new TreeNode(rootVal);
        int idx = inorderIndex.get(rootVal);
        root.left = build(inL, idx - 1);
        root.right = build(idx + 1, inR);
        return root;
    }
}