public class Solution {
    public int divide(int dividend, int divisor) {
        boolean flag = ((dividend ^ divisor) >> 31) == 0;
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);
        long result = ldivide(ldividend, ldivisor);
        return (result >= Integer.MAX_VALUE) ? (flag ? Integer.MAX_VALUE :Integer.MIN_VALUE) :
        (flag ? (int) result : -1 * (int) result);
    }

    private long ldivide(long dividend, long divisor) {
        if (dividend < divisor) return 0;
        long sum = divisor;
        long count = 1;
        while(sum << 1 <= dividend) {
            sum <<= 1;
            count <<= 1;
        }
        return count + ldivide(dividend - sum, divisor);
    }
}
