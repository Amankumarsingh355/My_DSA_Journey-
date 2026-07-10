class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        Integer[] order = new Integer[n];
        for (int i = 0; i < n; i++) {
            order[i] = i;
        }
        Arrays.sort(order, (a, b) -> Integer.compare(nums[a], nums[b]));
        int[] pos = new int[n];
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = nums[order[i]];
            pos[order[i]] = i;
        }
        int log = 1;
        while ((1 << log) < n) {
            log++;
        }
        int[][] jump = new int[log][n];
        int r = 0;
        for (int i = 0; i < n; i++) {
            if (r < i) {
                r = i;
            }
            while (r + 1 < n && values[r + 1] - values[i] <= maxDiff) {
                r++;
            }
            jump[0][i] = r;
        }
        for (int p = 1; p < log; p++) {
            for (int i = 0; i < n; i++) {
                jump[p][i] = jump[p - 1][jump[p - 1][i]];
            }
        }
        int[] answer = new int[queries.length];
        for (int q = 0; q < queries.length; q++) {
            int left = pos[queries[q][0]];
            int right = pos[queries[q][1]];
            if (left > right) {
                int temp = left;
                left = right;
                right = temp;
            }
            if (left == right) {
                answer[q] = 0;
                continue;
            }
            int current = left;
            int distance = 0;
            for (int p = log - 1; p >= 0; p--) {
                if (jump[p][current] < right) {
                    current = jump[p][current];
                    distance += 1 << p;
                }
            }
            if (jump[0][current] >= right) {
                answer[q] = distance + 1;
            } else {
                answer[q] = -1;
            }
        }
        return answer;
    }
}