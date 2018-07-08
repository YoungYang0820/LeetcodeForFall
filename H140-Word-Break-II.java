class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s, new HashSet<>(wordDict), new HashMap<>());
    }

    private List<String> dfs(String s, HashSet<String> dict, HashMap<String, LinkedList<String>> map) {
        if (map.containsKey(s)) return map.get(s);
        LinkedList<String> res = new LinkedList<>();
        if (0 == s.length()) {
            res.add("");
            return res;
        }

        for (String word : dict) {
            if (s.startsWith(word)) {
                List<String> sublist = dfs(s.substring(word.length()), dict, map);
                for (String sub : sublist)
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
            }
        }
        map.put(s, res);
        return res;
    }
}
