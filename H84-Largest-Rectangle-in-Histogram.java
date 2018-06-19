class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int len = heights.length;
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i <= len; i++) {
            int height = i == len ? 0 : heights[i];
            while (!stack.isEmpty() && height < heights[stack.peek()]) {
                int h = heights[stack.pop()];
                int start = stack.isEmpty() ? -1 : stack.peek();
                int area = (i - start - 1) * h;
                max = Math.max(max, area);
            }
            stack.push(i);
        }
        return max;
    }
}
