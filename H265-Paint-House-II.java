// Naive solution O(nk^2)
class Solution {
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        int n = costs.length, k = costs[0].length;
        int[][] dp = new int[n + 1][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                int min = Integer.MAX_VALUE;
                for (int d = 0; d < k; d++) {
                    if (i == 0 || j != d) min = Math.min(min, dp[i][d]);
                }
                dp[i + 1][j] = min + costs[i][j];
            }
        }
        int res = dp[n][0];
        for (int i = 1; i < k; i++) {
            res = Math.min(res, dp[n][i]);
        }
        return res;
    }
}

// Only record the min1 and min2 in the inner loop. O(nk)
class Solution {
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        int n = costs.length, k = costs[0].length;
        int prevMin1 = 0, prevMin2 = 0, prevIndex = -1;
        for (int i = 0; i < n; i++) {
            int min1 = Integer.MAX_VALUE;
            int min2 = Integer.MAX_VALUE;
            int minIdx = 0;
            for (int j = 0; j < k; j++) {
                int cost = costs[i][j] + (prevIndex == j ? prevMin2 : prevMin1);
                if (cost < min1) {
                    min2 = min1;
                    min1 = cost;
                    minIdx = j;
                }
                else if (cost < min2) {
                    min2 = cost;
                }
            }
            prevMin1 = min1;
            prevMin2 = min2;
            prevIndex = minIdx;
        }
        return prevMin1;
    }
}
