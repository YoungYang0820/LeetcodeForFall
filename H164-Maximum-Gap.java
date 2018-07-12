class Solution {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        if (nums.length == 2) return Math.abs(nums[0] - nums[1]);
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(num, min);
            max = Math.max(num, max);
        }

        int gap = (int) Math.ceil((double) (max - min) / (nums.length - 1));
        int[] minBucket = new int[nums.length - 1];
        int[] maxBucket = new int[nums.length - 1];
        Arrays.fill(minBucket, Integer.MAX_VALUE);
        Arrays.fill(maxBucket, Integer.MIN_VALUE);

        for (int num : nums) {
            if (num == min || num == max) continue;
            int index = (num - min) / gap;
            minBucket[index] = Math.min(minBucket[index], num);
            maxBucket[index] = Math.max(maxBucket[index], num);
        }

        int res = 0;
        int prev = min;
        for (int i = 0; i < minBucket.length; i++) {
            if (minBucket[i] == Integer.MAX_VALUE && maxBucket[i] == Integer.MIN_VALUE) continue;
            res = Math.max(res, minBucket[i] - prev);
            prev = maxBucket[i];
        }
        res = Math.max(res, max - prev);
        return res;
    }
}
