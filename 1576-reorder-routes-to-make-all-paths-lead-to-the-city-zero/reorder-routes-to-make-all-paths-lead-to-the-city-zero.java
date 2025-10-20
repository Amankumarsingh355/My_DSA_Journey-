class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] conn : connections) {
            int from = conn[0], to = conn[1];
            graph.get(from).add(new int[]{to, 1});
            graph.get(to).add(new int[]{from, 0});
        }
        boolean[] visited = new boolean[n];
        return dfs(graph, visited, 0);
    }
    private int dfs(List<List<int[]>> graph, boolean[] visited, int city) {
        visited[city] = true;
        int changes = 0;
        for (int[] edge : graph.get(city)) {
            int next = edge[0];
            int needsChange = edge[1];
            if (!visited[next]) {
                changes += needsChange + dfs(graph, visited, next);
            }
        }
        return changes;
    }
}