class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[left] == target) return left;
            if (nums[right] == target) return right;
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target) {
                if (nums[left] > nums[mid]) {
                    right = mid - 1;
                }
                else {
                    if (nums[left] < target) {
                        right = mid - 1;
                    }
                    else {
                        left = mid + 1;
                    }
                }
            }
            else {
                if (nums[left] < nums[mid]) {
                    left = mid + 1;
                }
                else {
                    if (nums[left] < target) {
                        right = mid - 1;
                    }
                    else {
                        left = mid + 1;
                    }
                }
            }
        }
        return -1;
    }
}
