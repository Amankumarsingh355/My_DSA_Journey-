class Solution {
    public boolean canFinish(int n, int[][] pre) {
        int indegree[] = new int[n];
        ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
        for(int i=0;i<n;i++) {
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0;i<pre.length;i++) {
            int a = pre[i][0];
            int b = pre[i][1];
            adj.get(b).add(a);
            indegree[a]++;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }
         int count = 0;
        while (!q.isEmpty()) {
            int curr = q.remove();
            count++;
            for (int conn : adj.get(curr)) {
                indegree[conn]--;
                if (indegree[conn] == 0) {
                    q.add(conn);
                }
            }
        }
        return count == n;      
    }
}