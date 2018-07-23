class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new LinkedList();
        helper(res, new LinkedList(), n, 2);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> item, int n, int start) {
        for (int i = start; i * i<= n; i++) {
            if (n % i == 0) {
                int factor = n / i;
                item.add(i);
                item.add(factor);
                res.add(new LinkedList(item));
                item.remove(item.size() - 1);
                helper(res, item, n/i, i);
                item.remove(item.size() - 1);
            }
        }
    }
}
