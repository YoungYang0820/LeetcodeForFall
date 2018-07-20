class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack();
        int tmp = 0;
        int res = 0;
        int sign = 1;
        for (char c : s.toCharArray()) {
            if (c == '+') {
                res += tmp * sign;
                tmp = 0;
                sign = 1;
            }
            else if (c == '-') {
                res += tmp * sign;
                tmp = 0;
                sign = -1;
            }
            else if (c == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            }
            else if (c == ')') {
                res += sign * tmp;
                tmp = 0;
                res *= stack.pop();
                res += stack.pop();
            }
            else if (Character.isDigit(c)) {
                tmp = tmp * 10 + (c - '0');
            }
        }
        res += tmp * sign;
        return res;
    }
}
