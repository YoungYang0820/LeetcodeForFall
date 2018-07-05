class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || gas.length == 0 || cost == null || cost.length == 0) return -1;
        int left = 0;
        int gasAcc = 0;
        int costAcc = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            gasAcc += gas[i];
            costAcc += cost[i];
            left += gas[i] - cost[i];
            if (left < 0) {
                left = 0;
                start = i + 1;
            }
        }
        return gasAcc >= costAcc ? start : -1;
    }
}
