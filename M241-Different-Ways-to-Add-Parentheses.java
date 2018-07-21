class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new LinkedList();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*') {
                List<Integer> part1 = diffWaysToCompute(input.substring(0, i));
                List<Integer> part2 = diffWaysToCompute(input.substring(i + 1));
                int tmp = 0;
                for (int num1 : part1) {
                    for (int num2 : part2) {
                        if (ch == '+') {
                            tmp = num1 + num2;
                        }
                        else if (ch == '-') {
                            tmp = num1 - num2;
                        }
                        else if (ch == '*') {
                            tmp = num1 * num2;
                        }
                        res.add(tmp);
                    }
                }
            }
        }
        if (res.size() == 0) {
            res.add(Integer.parseInt(input));
        }
        return res;
    }
}
