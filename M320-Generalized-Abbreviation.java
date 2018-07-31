class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList();
        helper(word, res, 0, 0, "");
        return res;
    }

    private void helper(String word, List<String> res, int index, int prevCount, String s) {
        if (index == word.length()) {
            if (prevCount > 0) s += prevCount;
            res.add(s);
            return;
        }
        if (index > 0 && prevCount > 0) {
            helper(word, res, index + 1, 0, s + prevCount + word.charAt(index));
        }
        helper(word, res, index + 1, prevCount + 1, s);
        if (prevCount == 0) helper(word, res, index + 1, 0, s + word.charAt(index));
    }
}
