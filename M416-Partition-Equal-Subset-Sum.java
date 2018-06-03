class Solution {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) return true;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) return false;
        sum /= 2;
        return helper(nums, sum, nums.length - 1);
    }

    private boolean helper(int[] nums, int sum, int index) {
        if (index < 0) return false;
        if (nums[index] == sum) return true;
        if (nums[index] > sum) return false;
        return helper(nums, sum - nums[index], index-1) || helper(nums, sum, index-1);
    }
}
