class Solution {
    public boolean wordPattern(String pattern, String str) {
        HashMap<String, Character> map = new HashMap();
        String[] words = str.split(" ");
        if (pattern.length() != words.length) return false;
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i]) && pattern.charAt(i) != map.get(words[i])) return false;
            if (!map.containsKey(words[i]) && map.containsValue(pattern.charAt(i))) return false;
            map.put(words[i], pattern.charAt(i));
        }
        return true;
    }
}
