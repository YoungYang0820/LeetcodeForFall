class WordDistance {
    private HashMap<String, ArrayList<Integer>> map;
    public WordDistance(String[] words) {
        map = new HashMap();
        for (int i = 0; i < words.length; i++) {
            ArrayList<Integer> list = map.getOrDefault(words[i], new ArrayList());
            list.add(i);
            map.put(words[i], list);
        }
    }

    public int shortest(String word1, String word2) {
        ArrayList<Integer> list1 = map.get(word1);
        ArrayList<Integer> list2 = map.get(word2);
        int min = Integer.MAX_VALUE;
        for (int i = 0, j = 0; i < list1.size() && j < list2.size();) {
            int index1 = list1.get(i);
            int index2 = list2.get(j);
            if (index1 < index2) {
                min = Math.min(index2 - index1, min);
                i++;
            } else {
                min = Math.min(index1 - index2, min);
                j++;
            }
        }
        return min;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */
