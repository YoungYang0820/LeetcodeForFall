class Solution {
    public boolean canJump(int[] nums) {
        int farthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0 && farthest == i) return false;
            farthest = Math.max(farthest, nums[i] + i);
        }
        return true;
    }
}
