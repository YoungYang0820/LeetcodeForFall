class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dp = new int[n + 1][m + 1];
        Arrays.fill(dp[0], 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i+1][j+1] = s.charAt(j) == t.charAt(i) ? dp[i][j] +  dp[i + 1][j]: dp[i + 1][j];
            }
        }
        return dp[n][m];
    }
}
