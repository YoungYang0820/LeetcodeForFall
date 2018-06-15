class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        backtrack(res, new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> tmp, int[] nums, boolean[] used) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || i > 0 && used[i - 1] && nums[i] == nums[i - 1]) {
                continue;
            }
            else {
                tmp.add(nums[i]);
                used[i] = true;
                backtrack(res, tmp, nums, used);
                used[i] = false;
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
