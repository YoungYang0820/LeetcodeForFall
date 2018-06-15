class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4) return res;
        Arrays.sort(nums);
        int max = nums[nums.length - 1];
        if (nums[0] * 4 > target || max * 4 < target) return res;
        for (int i = 0; i < nums.length - 3; i++) {
            int tmp = nums[i];
            if (i > 0 && tmp == nums[i-1]) continue;
            if (tmp + max * 3 < target) continue;
            if (tmp * 4 > target) break;
            if (tmp * 4 == target) {
                if (tmp == nums[i+3]) {
                    res.add(Arrays.asList(tmp, tmp, tmp, tmp));
                }
                break;
            }
            threeSum(nums, target - tmp, i + 1, nums.length - 1, res, tmp);
        }
        return res;
    }

    private void threeSum(int[] nums, int target, int start, int end, List<List<Integer>> res, int num1) {
        int max = nums[end];
        if (nums[start] * 3 > target || max * 3 < target) return;
        for (int i = start; i < end - 1; i++) {
            int tmp = nums[i];
            if (i > start && tmp == nums[i-1]) continue;
            if (tmp + max * 2 < target) continue;
            if (tmp * 3 > target) break;
            if (tmp * 3 == target) {
                if (tmp == nums[i+2]) {
                    res.add(Arrays.asList(num1, tmp, tmp, tmp));
                }
                break;
            }
            twoSum(nums, target - tmp, i + 1, end, res, num1, tmp);
        }
    }


    private void twoSum(int[] nums, int target, int start, int end, List<List<Integer>> res, int num1, int num2) {
        int max = nums[end];
        if (nums[start] * 2 > target || max * 2 < target) return;
        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum == target) {
                res.add(Arrays.asList(num1, num2, nums[start], nums[end]));
                int tmp = nums[start];
                while (++start < end && nums[start] == tmp);
                tmp = nums[end];
                while (start < --end && nums[end] == tmp);
            }
            if (sum > target) end--;
            if (sum < target) start++;
        }
    }
}
