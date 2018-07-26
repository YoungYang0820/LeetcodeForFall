class ValidWordAbbr {
    HashMap<String, Integer> map;
    HashSet<String> dict;
    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap();
        dict = new HashSet();
        for (String word : dictionary) {
            dict.add(word);
            if (word.equals("")) continue;
            String s = "" + word.charAt(0) + word.length() + word.charAt(word.length() - 1);
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
    }

    public boolean isUnique(String word) {
        if (word.equals("")) return true;
        if (word.length() == 1) return true;
        String s = "" + word.charAt(0) + word.length() + word.charAt(word.length() - 1);
        if (!map.containsKey(s)) return true;
        if (map.get(s) == 1 && dict.contains(word)) return true;
        return false;
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */
