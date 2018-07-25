class Solution {
    public int nthUglyNumber(int n) {
        int[] nums = new int[n];
        nums[0] = 1;
        int index2 = 1, index3 = 1, index5 = 1;
        int min2 = 2;
        int min3 = 3;
        int min5 = 5;
        for (int i = 1; i < n; i++) {
            int min = Math.min(min2, Math.min(min3, min5));
            nums[i] = min;
            if (min == min2) min2 = 2 * nums[index2++];
            if (min == min3) min3 = 3 * nums[index3++];
            if (min == min5) min5 = 5 * nums[index5++];
        }
        return nums[n - 1];
    }
}
