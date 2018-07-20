class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new LinkedList();
        if (nums == null || nums.length == 0) return res;
        if (nums.length == 1) {
            res.add(nums[0] + "");
            return res;
        }
        int prev = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] != 1) {
                if (prev == i - 1) {
                    res.add(nums[prev] + "");
                } else {
                    res.add(nums[prev] + "->" + nums[i - 1]);
                }
                prev = i;
            }
        }
        if (prev != nums.length - 1) {
            res.add(nums[prev] + "->" + nums[nums.length - 1]);
        }
        else {
            res.add(nums[prev] + "");
        }
        return res;
    }
}
