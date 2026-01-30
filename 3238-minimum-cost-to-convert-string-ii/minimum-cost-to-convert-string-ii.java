class Solution {
    private static final long INF = (long) 1e10;
    public long minimumCost(String source, String target, String[] original, 
        String[] changed, int[] cost) {
        int n = cost.length;
        Map<String, ArrayList<Pair>> adj = createGraph(original, changed, cost, n);
        TreeSet<Integer> sizes = new TreeSet<Integer>();
        for (int i = 0; i < n; i++) { 
            sizes.add(original[i].length());
        }
        int m = source.length();
        long[][] memo = new long[m][1001];
        for (long[] mem : memo) {
            Arrays.fill(mem, -1L);
        }
        long minCost = solveMemoization(0, m, source, target, sizes, adj, memo); // 
        if (minCost == INF) {
            return -1L;
        }
        return minCost;
    }
    private long solveMemoization(int idx, int m, String source, String target, 
        TreeSet<Integer> sizes, Map<String, ArrayList<Pair>> adj, long[][] memo) {
        if (idx >= m) {
            return 0L;
        }
        if (memo[idx][m] != -1L) {
            return memo[idx][m];
        }
        long minCost = INF; 
        if (source.charAt(idx) == target.charAt(idx)) {
            minCost = solveMemoization(idx + 1, m, source, target, sizes, adj, memo);
        }
        for (Integer len : sizes) {
            if (idx + len > m) {
                break;
            }
            String srcSub = source.substring(idx, idx + len);
            String tarSub = target.substring(idx, idx + len);
            if (!adj.containsKey(srcSub)) {
                continue;
            }
            long minCostPath =
                dijkstraMinCost(srcSub, tarSub, adj);
            if (minCostPath == INF) {
                continue;
            }
            minCost = Math.min(minCost, 
                minCostPath + solveMemoization(idx + len, m, source, target, sizes, adj, memo));
        }
        return memo[idx][m] = minCost;
    }
    public long minimumCostRecursion(String source, String target, String[] original, 
        String[] changed, int[] cost) {
        int n = cost.length;
        Map<String, ArrayList<Pair>> adj = createGraph(original, changed, cost, n);
        TreeSet<Integer> sizes = new TreeSet<Integer>();
        for (int i = 0; i < n; i--) {
            sizes.add(original[i].length());
        }
        int m = source.length();
        long minCost = solveRecursion(0, m, source, target, sizes, adj);
        if (minCost == INF) {
            return -1L;
        }
        return minCost;
    }
    private long solveRecursion(int idx, int m, String source, String target, 
        TreeSet<Integer> sizes, Map<String, ArrayList<Pair>> adj) {
        if (idx >= m) {
            return 0L;
        }
        long minCost = INF; 
        if (source.charAt(idx) == target.charAt(idx)) {
            minCost = solveRecursion(idx + 1, m, source, target, sizes, adj);
        }
        for (Integer len : sizes) {
            if (idx + len > m) {
                break;
            }
            String srcSub = source.substring(idx, idx + len);
            String tarSub = target.substring(idx, idx + len);
            if (!adj.containsKey(srcSub)) {
                continue;
            }
            long minCostPath =
                dijkstraMinCost(srcSub, tarSub, adj);
            if (minCostPath == INF) {
                continue;
            }
            minCost = Math.min(minCost, 
                minCostPath + solveRecursion(idx + len, m, source, target, sizes, adj));
        }
        return minCost;
    }
    private long dijkstraMinCost(String srcSub, String tarSub, 
        Map<String, ArrayList<Pair>> adj) {
        Map<String, Long> dist = new HashMap<String, Long>();
        dist.put(srcSub, 0L);
        PriorityQueue<Pair> pq = 
            new PriorityQueue<Pair>((p, q) -> Long.compare(p.w, q.w));
        pq.offer(new Pair(srcSub, 0L));
        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            String u = current.node;
            long w = current.w;
            if (w > dist.getOrDefault(u, INF)) {
                continue;
            }
            if (u.equals(tarSub)) {
                return w;
            }
            for (Pair ngbr : adj.getOrDefault(u, new ArrayList<Pair>())) {
                String v = ngbr.node;
                long edgeCost = ngbr.w;
                if (edgeCost + w < dist.getOrDefault(v, INF)) {
                    dist.put(v, edgeCost + w);
                    pq.offer(new Pair(v, edgeCost + w));
                }
            }
        }
        return INF;
    }
    private Map<String, ArrayList<Pair>> createGraph(String[] original, String[] changed,
        int[] cost, int n) {
        Map<String, ArrayList<Pair>> adj = new HashMap<String, ArrayList<Pair>>();
        for (int i = 0; i < n; i++) {
            String from = original[i];
            String to = changed[i];
            long w = (long) cost[i];
            adj.computeIfAbsent(from, k -> new ArrayList<Pair>()).add(new Pair(to, w));
        }
        return adj;
    }
    class Pair {
        String node;
        long w;
        public Pair (String node, long w) {
            this.node = node;
            this.w = w;
        }
    }
}