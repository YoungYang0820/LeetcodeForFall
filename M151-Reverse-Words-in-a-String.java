public class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        if (words.length == 0) return "";
        for (int i = words.length - 1; i >= 0; i--) {
            if (words[i].equals("")) continue;
            sb.append(words[i] + " ");
        }
        if (sb.length() == 0) return "";
        return sb.toString().substring(0, sb.length() - 1);
    }
}
