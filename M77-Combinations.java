class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        helper(n, k, 1, new ArrayList<>(), res);
        return res;
    }

    private void helper(int n, int k, int start, List<Integer> tmp, List<List<Integer>> res) {
        if (tmp.size() == k) {
            res.add(new ArrayList<>(tmp));
        }
        if (start > n) return;
        for (int i = start; i <= n; i++) {
            tmp.add(i);
            helper(n, k, i + 1, tmp, res);
            tmp.remove(tmp.size() - 1);
        }
    }
}
