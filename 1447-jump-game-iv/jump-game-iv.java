class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if(n == 1) return 0;
        
        return solveBFS(arr, n);
    }
    private int solveBFS(int[] arr, int n) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>(); // storing Index
        queue.offer(0);
        visited[0] = true;
        int steps = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int curr = queue.poll();
                if(curr == n - 1) {
                    return steps;
                }
                int left = curr - 1;
                int right = curr + 1;
                if(left >= 0 && !visited[left]) {
                    queue.offer(left);
                    visited[left] = true;
                }
                if(right < n && !visited[right]) {
                    queue.offer(right);
                    visited[right] = true;
                }
                if(map.containsKey(arr[curr])) {
                    for(int index : map.get(arr[curr])) {
                        if(!visited[index]) {
                            queue.offer(index);
                            visited[index] = true;
                        }
                    }
                    map.remove(arr[curr]);
                }
            }
            steps++;
        }
        return 1;
    }
}