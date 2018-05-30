public class Solution {
    public String intToRoman(int num) {
        String[] D4 = {"", "M", "MM", "MMM"};
        String[] D3 = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] D2 = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] D1 = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return D4[num / 1000] + D3[(num / 100) % 10] + D2[(num / 10) % 10] + D1[num % 10];
    }
}
