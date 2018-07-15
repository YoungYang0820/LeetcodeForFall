class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int prevNo = 0;
        int prevYes = 0;
        for (int num : nums) {
            int tmp = prevNo;
            prevNo = Math.max(prevNo, prevYes);
            prevYes = num + tmp;
        }
        return Math.max(prevNo, prevYes);
    }
}
