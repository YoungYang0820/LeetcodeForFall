class Solution {
    public int countPrimes(int n) {
        if (n < 3) return 0;
        boolean[] dp = new boolean[n];
        Arrays.fill(dp, false);
        int res = 0;
        for (int i = 2; i < n; i++) {
            if (!dp[i]) {
                for (int j = 2; i * j < n; j++) {
                    dp[i * j] = true;
                }
                res++;
            }
        }
        return res;
    }
}
