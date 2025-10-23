import java.util.Deque;
import java.util.ArrayDeque;
public class Solution {
    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        Integer prev = null;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (prev != null && cur.val <= prev) return false;
            prev = cur.val;
            cur = cur.right;
        }
        return true;
    }
}