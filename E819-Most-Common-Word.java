class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> dict = new HashSet();
        for (String word : banned) {
            dict.add(word);
        }
        String res = "";
        int max = 0;
        String[] words = paragraph.replaceAll("[!?',;.]", "").toLowerCase().split(" ");
        HashMap<String, Integer> map = new HashMap();
        for (String word : words) {
            if (dict.contains(word)) continue;
            int count = map.getOrDefault(word, 0) + 1;
            if (count > max) {
                max = count;
                res = word;
            }
            map.put(word, count);
        }
        return res;
    }
}
