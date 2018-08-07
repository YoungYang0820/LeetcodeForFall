class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int num = 0;
        int index = 0;
        for (int i = 0; i < abbr.length(); i++) {
            char c = abbr.charAt(i);
            if (Character.isDigit(c)) {
                if (c == '0' && num == 0) return false;
                num = num * 10 + (c - '0');
                if (i == abbr.length() - 1) {
                    return (index + num) == word.length();
                }
            }
            else {
                index += num;
                num = 0;
//                if (i == abbr.length() && index == word.length()) return true;
                if (index >= word.length() || c != word.charAt(index)) {
                    return false;
                }
                else index++;
            }
        }
        return (index + num) == word.length();
    }
}
