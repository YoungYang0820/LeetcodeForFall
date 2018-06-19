class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        helper(nums, new ArrayList<>(), 0, res);
        return res;
    }

    private void helper(int[] nums, List<Integer> tmp, int start, List<List<Integer>> res) {
        if (start <= nums.length)
            res.add(new ArrayList<>(tmp));
        for (int i = start; i < nums.length; i++) {
            tmp.add(nums[i]);
            helper(nums, tmp, i + 1, res);
            tmp.remove(tmp.size() - 1);
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) i++;
        }
    }
}
