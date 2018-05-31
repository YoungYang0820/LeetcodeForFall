class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> brackets = new HashMap<>();
        brackets.put('(', ')');
        brackets.put('[', ']');
        brackets.put('{', '}');
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (brackets.containsKey(ch)) {
                stack.push(brackets.get(ch));
            }
            else {
                if (stack.isEmpty() || ch != stack.pop()) return false;
            }
        }
        if (!stack.isEmpty()) return false;
        return true;
    }
}
