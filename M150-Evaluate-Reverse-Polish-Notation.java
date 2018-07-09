class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) return 0;
        Stack<Integer> s = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+")) {
                s.push(s.pop() + s.pop());
            }
            else if (token.equals("-")) {
                int dom = s.pop();
                s.push(s.pop() - dom);
            }
            else if (token.equals("*")) {
                s.push(s.pop() * s.pop());
            }
            else if (token.equals("/")) {
                int dom = s.pop();
                s.push(s.pop() / dom);
            }
            else {
                s.push(new Integer(token));
            }
        }
        return s.pop();
    }
}
