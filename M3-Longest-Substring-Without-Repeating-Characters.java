class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int longest = 0;
        int prev = -1;
        for (int i = 0; i < s.length(); i++) {
            prev = Math.max(map.getOrDefault(s.charAt(i), -1), prev);
            longest = Math.max(longest, i - prev);
            map.put(s.charAt(i), i);
        }
        return longest;
    }
}
