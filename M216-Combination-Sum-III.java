class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new LinkedList();
        helper(k, 1, n, res, new LinkedList());
        return res;
    }

    private void helper(int k, int start, int n, List<List<Integer>> res, List<Integer> tmp) {
        if (n == 0 && k == 0) res.add(new ArrayList(tmp));
        if (start > 9 || k == 0) return;
        for (int i = start; i <= 9; i++) {
            tmp.add(i);
            helper(k - 1, i + 1, n - i, res, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
