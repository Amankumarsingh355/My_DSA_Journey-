class Solution {
    class pairDuo{
        int chr;
        int cst;
        public pairDuo(int chr, int cst){
            this.chr = chr;
            this.cst = cst;
        }
    }
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int len = source.length();
        int lenOr = original.length;
        ArrayList<pairDuo>[] adj = new ArrayList[26];

        for(int i = 0; i < 26; i++) adj[i] = new ArrayList<>();
        for(int i = 0;i < lenOr;i++){
            int org = original[i]-'a';
            int chg = changed[i]-'a';

            adj[org].add(new pairDuo(chg, cost[i]));
        }

        long[][] lessChar = new long[26][26];
        for(long[] les: lessChar){
            Arrays.fill(les, -1);
        }
        long ans = 0;

        for(int i = 0;i < len;i++){
            int src = source.charAt(i)-'a';
            int tgt = target.charAt(i)-'a';
            
            if(lessChar[src][tgt] == -1){
                dijkstra(src, lessChar, adj);
            }
            
            if(lessChar[src][tgt] == Integer.MAX_VALUE) return -1;
            ans += lessChar[src][tgt];
        }

        return ans;
    }
    public void dijkstra(int node, long[][] lessTime, ArrayList<pairDuo>[] adj){
        long[] dst = new long[26];
        Arrays.fill(dst, Integer.MAX_VALUE);
        dst[node] = 0;
        PriorityQueue<pairDuo> pq = new PriorityQueue<>((a,b)->a.cst-b.cst);
        pq.add(new pairDuo(node, 0));
        while(!pq.isEmpty()){
            pairDuo temp = pq.poll();
            int chr = temp.chr;
            int cst = temp.cst;
            if(cst > dst[chr]) continue;
            for(pairDuo p: adj[chr]){
                int tempCst = p.cst+cst;
                if(dst[p.chr] > tempCst){
                    dst[p.chr] = tempCst;
                    pq.add(new pairDuo(p.chr, tempCst));
                }
            }
        }
        System.arraycopy(dst, 0, lessTime[node], 0, 26);
    }
}