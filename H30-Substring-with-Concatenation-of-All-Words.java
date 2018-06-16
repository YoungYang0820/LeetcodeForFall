class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        if (s == null || words == null || words.length == 0) return new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<String, Integer> map =new HashMap<>();
        int slen = s.length();
        int words_len = words.length;
        int word_len = words[0].length();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i <= slen - words_len * word_len; i++) {
            HashMap<String, Integer> tmp = new HashMap<>(map);
            int count = words_len;
            int j = i;
            while (j <= slen - word_len) {
                String str = s.substring(j, j + word_len);
                if (!(tmp.containsKey(str) && tmp.get(str) > 0)) break;
                j += word_len;
                count--;
                tmp.put(str, tmp.get(str) - 1);
            }
            if (count == 0) res.add(i);
        }
        return res;
    }
}
