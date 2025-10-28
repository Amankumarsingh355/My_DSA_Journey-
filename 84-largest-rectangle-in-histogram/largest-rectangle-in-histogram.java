class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int n = heights.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;
        for (int i = 0; i <= n; i++) {
            int h = (i == n) ? 0 : heights[i];
            while (!stack.isEmpty() && h < heights[stack.peekLast()]) {
                int height = heights[stack.pollLast()];
                int left = stack.isEmpty() ? 0 : stack.peekLast() + 1;
                int right = i - 1;
                int width = right - left + 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.offerLast(i);
        }
        return maxArea;
    }
}