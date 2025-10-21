class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length, n = maze[0].length;
        boolean[][] seen = new boolean[m][n];
        int sr = entrance[0], sc = entrance[1];
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sr, sc, 0});
        seen[sr][sc] = true;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1], d = cur[2];
            if (!(r == sr && c == sc) && (r == 0 || r == m-1 || c == 0 || c == n-1)) {
                return d;
            }
            for (int[] dir : dirs) {
                int nr = r + dir[0], nc = c + dir[1];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                if (seen[nr][nc]) continue;
                if (maze[nr][nc] == '+') continue;
                seen[nr][nc] = true;
                q.offer(new int[]{nr, nc, d + 1});
            }
        }
        return -1;
    }
}