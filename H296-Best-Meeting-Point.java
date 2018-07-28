class Solution {
    public int minTotalDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        List<Integer> listX = new ArrayList();
        List<Integer> listY = new ArrayList();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if ((grid[i][j] & 1) == 1) {
                    listX.add(j);
                    listY.add(i);
                }
            }
        }

        return helper(listX) + helper(listY);
    }

    private int helper(List<Integer> list) {
        int l = 0, r = list.size() - 1;
        int res = 0;
        Collections.sort(list);
        while (l < r) {
            res += list.get(r--) - list.get(l++);
        }
        return res;
    }
}
