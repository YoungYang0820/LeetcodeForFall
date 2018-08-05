class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        if (nums == null || nums.length == 0) return nums;
        int[] arr = new int[nums.length];
        if (a == 0) {
            for (int i = 0; i < nums.length; i++) {
                if (b > 0) {
                    arr[i] = nums[i] * b + c;
                }
                else {
                    arr[i] = nums[nums.length - i - 1] * b + c;
                }
            }
            return arr;
        }
        double axis = -(double) b/a/2;
        int left = 0, right = nums.length - 1, index = 0;
        while (left <= right) {
            if (Math.abs((double) (nums[left]) - axis) > Math.abs((double) (nums[right]) - axis)) {
                if (a > 0) {
                    arr[nums.length - 1 - index] = value(nums[left], a, b, c);
                }
                else {
                    arr[index] = value(nums[left], a, b, c);
                }
                left++;
            }
            else {
                if (a > 0) {
                    arr[nums.length - 1 - index] = value(nums[right], a, b, c);
                }
                else {
                    arr[index] = value(nums[right], a, b, c);
                }
                right--;
            }
            index++;
        }
        return arr;
    }

    private int value(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }
}
