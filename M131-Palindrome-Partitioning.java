class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new LinkedList<>();
        helper(s, 0, res, new ArrayList<>());
        return res;
    }

    private void helper(String s, int start, List<List<String>> res, List<String> tmp) {
        if (start == s.length()) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                tmp.add(s.substring(start, i + 1));
                helper(s, i + 1, res, tmp);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
}
