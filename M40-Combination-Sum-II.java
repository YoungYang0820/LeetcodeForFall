class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        return combination(candidates, target, 0);
    }

    private List<List<Integer>> combination(int[] candidates, int target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (candidates[i] < target) {
                for (List<Integer> tmp : combination(candidates, target - candidates[i], i + 1)) {
                    tmp.add(candidates[i]);
                    res.add(tmp);
                }
            }
            else if (candidates[i] == target) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(candidates[i]);
                res.add(tmp);
            }
            else {
                break;
            }
        }
        return res;
    }
}
