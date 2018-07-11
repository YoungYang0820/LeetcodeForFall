class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap();
        int low = 0, high = 0, max = 0;
        char[] str = s.toCharArray();
        while (high < str.length) {
            if (map.size() <= 2) {
                map.put(str[high], high++);
            }
            if (map.size() > 2) {
                int left = str.length;
                for (int i : map.values()) {
                    left = Math.min(i, left);
                }
                map.remove(str[left]);
                low = left + 1;
            }
            max = Math.max(max, high - low);
        }
        return max;
    }
}
