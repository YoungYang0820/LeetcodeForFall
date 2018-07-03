class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int max = 0;
        int prev = prices[0];
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - prev);
            prev = Math.min(prev, prices[i]);
        }
        return max;
    }
}
