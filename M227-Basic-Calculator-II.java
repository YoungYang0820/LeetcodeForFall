class Solution {
    public int calculate(String s) {
        String[] numString = s.replaceAll("\\s", "").split("[\\+\\-\\*\\/]");
        int[] nums = new int[numString.length];
        for (int i = 0; i < numString.length; i++) {
            nums[i] = Integer.parseInt(numString[i]);
        }
        if (nums.length == 1) return nums[0];
        int res = 0;
        int tmp = 0;
        int sign = 1;
        int i = 0;
        for (char c : s.toCharArray()) {
            if (c == '+') {
                res += sign * nums[i];
                sign = 1;
            }
            else if (c == '-') {
                res += sign * nums[i];
                sign = -1;
            }
            else if (c == '*') {
                nums[i + 1] = nums[i] * nums[i + 1];
            }
            else if (c == '/') {
                nums[i + 1] = nums[i] / nums[i + 1];
            }
            else {
                continue;
            }
            i++;
        }
        res += sign * nums[nums.length - 1];
        return res;
    }
}
