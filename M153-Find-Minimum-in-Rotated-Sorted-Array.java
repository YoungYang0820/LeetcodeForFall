class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        return binarySearch(nums, 0, nums.length - 1);
    }

    private int binarySearch(int[] nums, int left, int right) {
        if (right - left <= 1) return Math.min(nums[left], nums[right]);
        int mid = left + (right - left) / 2;
        if (nums[left] < nums[mid] && nums[left] < nums[right]) return nums[left];
        if (nums[mid] > nums[right]) return binarySearch(nums, mid, right);
        if (nums[left] > nums[mid]) return binarySearch(nums, left, mid);
        return nums[mid];
    }
}
