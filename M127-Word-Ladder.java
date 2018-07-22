class Solution {
    private int res = Integer.MAX_VALUE;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
//        List<List<String>> res = new LinkedList();
        if (!wordList.contains(endWord)) return 0;

        HashSet<String> set1 = new HashSet();
        HashSet<String> set2 = new HashSet();
        set1.add(beginWord);
        set2.add(endWord);
        HashMap<String, List<String>> map = new HashMap();

        helper(wordSet, set1, set2, map, false);
        generate(beginWord, endWord, map, 1);
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    private boolean helper(Set<String> wordSet, Set<String> set1, Set<String> set2, Map<String, List<String>> map, boolean flip) {
        if (set1.isEmpty()) return false;
        if (set1.size() > set2.size()) return helper(wordSet, set2, set1, map, !flip);

        wordSet.removeAll(set1);
        wordSet.removeAll(set2);

        boolean done = false;
        HashSet<String> set = new HashSet();

        for (String str : set1) {
            for (int i = 0; i < str.length(); i++) {
                char[] ch = str.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    ch[i] = c;
                    String word = new String(ch);
                    String key = flip ? word : str;
                    String value = flip ? str : word;
                    List<String> list = map.getOrDefault(key, new ArrayList());

                    if (set2.contains(word)) {
                        done = true;
                        list.add(value);
                        map.put(key, list);
                    }

                    if (!done && wordSet.contains(word)) {
                        set.add(word);
                        list.add(value);
                        map.put(key, list);
                    }
                }
            }
        }
        return done || helper(wordSet, set2, set, map, !flip);
    }

    private void generate(String start, String end, HashMap<String, List<String>> map, int step) {
        if (start.equals(end)) {
            res = Math.min(res, step);
        }

        if (!map.containsKey(start)) return;

        for (String word : map.get(start)) {
            generate(word, end, map, step + 1);
        }
    }
}
