class Solution {
    public int jump(int[] nums) {
        int end = 0, farthest = 0;
        int res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == end) {
                res++;
                end = farthest;
                if (end >= nums.length - 1) break;
            }
        }
        return res;
    }
}
