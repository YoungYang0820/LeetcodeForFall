class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) return 0;
        if (triangle.size() == 1) return triangle.get(0).get(0);
        if (triangle.size() == 2) return triangle.get(0).get(0) + Math.min(triangle.get(1).get(0), triangle.get(1).get(1));
        int min = Integer.MAX_VALUE;
        for (int i = 2; i < triangle.size(); i++) {
            List<Integer> tmp = triangle.get(i);
            tmp.set(0, tmp.get(0) + triangle.get(i - 1).get(0));
            if (i == triangle.size() - 1) min = Math.min(min, tmp.get(0));
            for (int j = 1; j < tmp.size() - 1; j++) {
                tmp.set(j, tmp.get(j) + Math.min(triangle.get(i - 1).get(j), triangle.get(i - 1).get(j - 1)));
                if (i == triangle.size() - 1) min = Math.min(min, tmp.get(j));
            }
            tmp.set(tmp.size() - 1, tmp.get(tmp.size() - 1) + triangle.get(i - 1).get(tmp.size() - 2));
            if (i == triangle.size() - 1) min = Math.min(min, tmp.get(tmp.size() - 1));
        }
        return min + triangle.get(0).get(0);
    }
}
