class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        if (words == null || words.length == 0) return 0;
        int prev = -words.length;
        String prevS = words[0].equals(word2) ? word2 : word1;
        String theOtherS = word1.equals(prevS) ? word2 : word1;
        int min = words.length;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(theOtherS)) {
                min = Math.min(i - prev, min);
                prev = i;
                String tmp = prevS;
                prevS = theOtherS;
                theOtherS = tmp;
            }
            if (words[i].equals(prevS)) {
                prev = i;
            }
        }
        return min;
    }
}
