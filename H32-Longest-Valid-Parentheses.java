class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int max = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(0);
            }
            else {
                if (stack.size() > 1) {
                    int val = stack.pop();
                    stack.push(stack.pop() + val + 2);
                    max = Math.max(max, stack.peek());
                }
                else {
                    stack.clear();
                    stack.push(0);
                }
            }
        }
        return max;
    }
}
