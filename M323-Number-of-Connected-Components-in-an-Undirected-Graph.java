class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] ids = new int[n];
        int[] sz = new int[n];
        int num = n;

        for (int i = 0; i < n; i++) {
            ids[i] = i;
        }

        for (int[] edge : edges) {
            int i = edge[0];
            int j = edge[1];
            int ri = root(ids, i);
            int rj = root(ids, j);
            if (ri != rj) {
                if (sz[ri] < sz[rj]) {
                    ids[ri] = rj;
                    sz[rj] += sz[ri];
                }
                else {
                    ids[rj] = ri;
                    sz[ri] += sz[rj];
                }
                num--;
            }
        }
        return num;
    }

    private int root(int[] ids, int i) {
        for (; ids[i] != i; i = ids[i]) {
            ids[i] = ids[ids[i]];
        }
        return ids[i];
    }
}
