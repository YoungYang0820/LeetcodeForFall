class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList();
        helper(res, "", 0, 0, n);
        return res;
    }

    private void helper(ArrayList<String> res, String tmp, int left, int right, int n) {
        if (tmp.length() == n * 2) {
            res.add(tmp);
            return;
        }
        if (left < n) {
            helper(res, tmp + "(", left+1, right, n);
        }

        if (right < left) {
            helper(res, tmp + ")", left, right+1, n);
        }
    }
}
