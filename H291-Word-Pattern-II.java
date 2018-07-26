class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        HashMap<Character, String> map = new HashMap();
        HashSet<String> set = new HashSet();
        return isMatch(pattern, str, 0, 0, map, set);
    }

    private boolean isMatch(String pattern, String str, int i, int j, HashMap<Character, String> map, HashSet<String> set) {
        if (i == pattern.length() && j == str.length()) return true;
        if (i == pattern.length() || j == str.length()) return false;

        char c = pattern.charAt(i);
        if (map.containsKey(c)) {
            String word = map.get(c);
            if (!str.startsWith(word, j)) return false;
            return isMatch(pattern, str, i + 1, j + word.length(), map, set);
        }

        for (int k = j; k < str.length(); k++) {
            String word = str.substring(j, k + 1);
            if (set.contains(word)) continue;
            map.put(c, word);
            set.add(word);
            if (isMatch(pattern, str, i + 1, k + 1, map, set)) return true;
            map.remove(c);
            set.remove(word);
        }
        return false;
    }
}
