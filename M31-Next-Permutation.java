class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int small = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i+1]) {
                small = i;
                break;
            }
        }
        if (small == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        int large = -1;
        for (int i = nums.length - 1; i > small; i--) {
            if (nums[i] > nums[small]) {
                large = i;
                break;
            }
        }
        swap(nums, small, large);
        reverse(nums, small + 1, nums.length - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }
}
