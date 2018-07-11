class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        return binarySearch(nums, low, high);
    }
    private int binarySearch(int[] nums, int low, int high) {
        if (high - low <= 1) return Math.min(nums[low], nums[high]);
        int mid = (low + high) / 2;
        if (nums[low] < nums[mid] && nums[low] < nums[high]) return nums[low];
        if (nums[mid] > nums[high]) return binarySearch(nums, mid, high);
        if (nums[low] > nums[mid]) return binarySearch(nums, low, mid);
        return Math.min(binarySearch(nums, mid, high), binarySearch(nums, low, mid));
    }
}
