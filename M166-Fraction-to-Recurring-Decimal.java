class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";

        StringBuilder sb = new StringBuilder();
        sb.append((numerator > 0) ^ (denominator > 0) ? "-" : "");
        long lnum = Math.abs((long) numerator);
        long lde = Math.abs((long) denominator);
        sb.append(lnum / lde);
        lnum %= lde;
        if (lnum == 0) return sb.toString();

        HashMap<Long, Integer> map = new HashMap();
        sb.append(".");
        map.put(lnum, sb.length());

        while (lnum != 0) {
            lnum *= 10;
            sb.append(lnum / lde);
            lnum %= lde;
            if (map.containsKey(lnum)) {
                int index = map.get(lnum);
                sb.insert(index, "(");
                sb.append(")");
                break;
            }
            else {
                map.put(lnum, sb.length());
            }
        }
        return sb.toString();
    }
}
