class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length <= 1 || k == 0) return false;
        int p = 0, q = 1;
        while (p < nums.length - 1) {
            if (p != q && Math.abs((long) nums[p] - nums[q]) <= t) return true;
            if (q - p == k || q == nums.length - 1) {
                p++;
                if (t != 0) q = p + 1;
            }
            else {
                q++;
            }
        }
        return false;
    }
}
