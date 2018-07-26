class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int p1 = 0, p2 = 0;
        while (p2 < nums.length) {
            if (nums[p2] != 0) nums[p1++] = nums[p2];
            p2++;
        }
        while (p1 < nums.length) {
            nums[p1++] = 0;
        }
    }
}
