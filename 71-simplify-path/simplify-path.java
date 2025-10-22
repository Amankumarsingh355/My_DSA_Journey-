public class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        for (String part : path.split("/")) {
            if (part.isEmpty() || part.equals(".")) continue;
            if (part.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else {
                stack.push(part);
            }
        }
        if (stack.isEmpty()) return "/";
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append('/').append(stack.removeLast());
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.simplifyPath("/home/"));             
        System.out.println(s.simplifyPath("/home//foo/"));        
        System.out.println(s.simplifyPath("/home/user/Documents/../Pictures"));
        System.out.println(s.simplifyPath("/../"));                     
        System.out.println(s.simplifyPath("/.../a/../b/c/../d/./"));    
    }
}