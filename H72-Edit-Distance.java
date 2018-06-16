class Solution {
    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        int[][] dp = new int[l1+1][l2+1];
        dp[0][0] = 0;
        for (int i = 1; i <= l1; i++) {
            dp[i][0] = dp[i-1][0] + 1;
        }
        for (int i = 1; i <= l2; i++) {
            dp[0][i] = dp[0][i-1] + 1;
        }
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    int insert = dp[i][j-1] + 1;
                    int delete = dp[i-1][j] + 1;
                    int replace = dp[i-1][j-1] + 1;
                    dp[i][j] = Math.min(insert, Math.min(delete, replace));
                }
            }
        }
        return dp[l1][l2];
    }
}
