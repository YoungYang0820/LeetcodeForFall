class Solution {
    private int rob(int[] nums, int l, int h) {
        int prevNo = 0;
        int prevYes = 0;
        for (int i = l; i <= h; i++) {
            int tmp = prevNo;
            prevNo = Math.max(prevNo, prevYes);
            prevYes = tmp + nums[i];
        }
        return Math.max(prevNo, prevYes);
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }
}
