class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = nums[0];
        int preMin = nums[0];
        int preMax = nums[0];
        int maxProduct = 0;
        int minProduct = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                maxProduct = Math.max(nums[i], preMin * nums[i]);
                minProduct = Math.min(nums[i], preMax * nums[i]);
            }
            else {
                maxProduct = Math.max(nums[i], preMax * nums[i]);
                minProduct = Math.min(nums[i], preMin * nums[i]);
            }
            preMin = minProduct;
            preMax = maxProduct;
            max = Math.max(max, maxProduct);
        }
        return max;
    }
}
