public class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[left] == target) return true;
            if (nums[right] == target) return true;
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) return true;
            int mid2 = mid;
            while (mid > 0 && nums[mid] == nums[mid-1]) mid--;
            while (mid2 < nums.length - 1 && nums[mid2] == nums[mid2+1]) mid2++;
            if (nums[mid] > target) {
                if (nums[left] > nums[mid]) {
                    right = mid - 1;
                }
                else {
                    if (nums[left] < target) {
                        right = mid - 1;
                    }
                    else {
                        left = mid2 + 1;
                    }
                }
            }
            else {
                if (nums[left] < nums[mid]) {
                    left = mid2 + 1;
                }
                else if (nums[left] > nums[mid]) {
                    if (nums[left] < target) {
                        right = mid - 1;
                    }
                    else {
                        left = mid2 + 1;
                    }
                }
                else {
                    if (mid == 0 || nums[mid] == nums[mid-1]) left = mid2 + 1;
                    else right = mid - 1;
                }
            }
        }
        return false;
    }

}
