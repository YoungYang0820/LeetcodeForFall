class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break;
            int left = i + 1;
            int right = nums.length - 1;
            if (i == 0 || nums[i] != nums[i-1]) {
                while (left < right) {
                    if (nums[i] + nums[left] + nums[right] == 0) {
                        res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        while (left < right && nums[left+1] == nums[left]) {
                            left++;
                        }
                        while (left < right && nums[right-1] == nums[right]) {
                            right--;
                        }
                        left++;
                        right--;
                    }
                    else if (nums[i] + nums[left] + nums[right] > 0) {
                        right--;
                    }
                    else {
                        left++;
                    }
                }
            }
        }
        return res;
    }
}
