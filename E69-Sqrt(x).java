class Solution {
    public int mySqrt(int x) {
        long r = x;
        while (r*r - x > 0) {
            r = (r + x/r) / 2;
        }
        return (int) r;
    }
}
