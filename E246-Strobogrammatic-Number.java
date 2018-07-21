class Solution {
    public boolean isStrobogrammatic(String num) {
        HashMap<Character, Character> map = new HashMap();
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
        map.put('1', '1');
        map.put('0', '0');
        int l = 0, h = num.length() - 1;
        while (l < h) {
            if (map.containsKey(num.charAt(l)) && map.get(num.charAt(l)) == num.charAt(h)) {
                l++;
                h--;
            }
            else {
                return false;
            }
        }
        if (l == h) return num.charAt(l) == '1' || num.charAt(l) == '8' || num.charAt(l) == '0';
        return true;
    }
}
