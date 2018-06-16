class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int start = 0, end = 0, head = 0, min = Integer.MAX_VALUE, count = t.length();

        while (end < s.length()) {
            char ch = s.charAt(end++);
            int tmp = map.getOrDefault(ch, 0);

            if (tmp > 0) {
                count--;
            }
            map.put(ch, tmp - 1);
            while (count == 0) {
                if (end - start < min) {
                    min = end - start;
                    head = start;
                }
                ch = s.charAt(start++);
                tmp = map.getOrDefault(ch, -1);
                map.put(ch, tmp + 1);
                if (tmp == 0) {
                    count++;
                }
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(head, head + min);
    }
}
