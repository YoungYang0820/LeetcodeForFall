class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(1);
            for (int j = 0; j < i - 1; j++) {
                tmp.add(res.get(i - 1).get(j) + res.get(i - 1).get(j + 1));
            }
            if (i != 0) tmp.add(1);
            res.add(tmp);
        }
        return res;
    }
}
