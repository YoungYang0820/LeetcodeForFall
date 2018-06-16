public class Solution {
    public List<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<>();
        if (digits.length() == 0) return result;
        String[] map = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        result.add("");
        int length = 1;
        for (int i = 0; i < digits.length(); i++) {
            if (digits.charAt(i) == '1' || digits.charAt(i) == '0') return new ArrayList<String>();
            for (int j = 0; j < length; j++) {
                String tmp = result.get(j);
                result.set(j, tmp + map[digits.charAt(i) - '0'].charAt(0));
                for (int k = 1; k < map[digits.charAt(i) - '0'].length(); k++) {
                    result.add(tmp + map[digits.charAt(i) - '0'].charAt(k));
                }
            }
            length = result.size();
        }
        return result;
    }
}
