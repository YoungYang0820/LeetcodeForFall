public class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                n /= 2;
                x = x * x;
            }
            n = -n;
            x = 1/x;
        }
        return helper(x, n);
    }
    private double helper(double x, int n) {
        if (n == 1) return x;
        return n%2 == 1? x * helper(x * x, n/2) : helper(x * x, n/2);
    }
}
