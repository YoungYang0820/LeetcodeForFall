class Solution {
    public boolean validWordSquare(List<String> words) {
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            for (int j = 0; j < word.length(); j++) {
                if (j >= words.size()) return false;
                String word2 = words.get(j);
                if (i >= word2.length() || word.charAt(j) != word2.charAt(i)) return false;
            }
        }
        return true;
    }
}
