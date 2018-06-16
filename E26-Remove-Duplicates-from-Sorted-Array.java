class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int pointer = 1;
        int prev = nums[0];
        int length = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != prev) {
                nums[pointer++] = nums[i];
                length++;
                prev = nums[i];
            }
        }
        return length;
    }
}
