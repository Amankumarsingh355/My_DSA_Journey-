class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        ArrayList<Double> ans = new ArrayList<>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        list = lo(root);
        for(int i=0; i<list.size(); i++){
            ArrayList<Integer> temp = list.get(i);
            double sum = 0;
            for(int j=0; j<temp.size(); j++){
                sum += temp.get(j);
            }
            sum /= (double) temp.size();
            ans.add(sum);
        }

        return ans;
        
    }
    public ArrayList<ArrayList<Integer>> lo(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        while(!queue.isEmpty()){
            int n = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            for(int i=0; i<n; i++){
                if(queue.peek().left != null)
                    queue.offer(queue.peek().left);
                if(queue.peek().right != null)
                    queue.offer(queue.peek().right);
                list.add(queue.peek().val);
                queue.poll();
            }
            ans.add(list);
        }
        return ans;
    }
}