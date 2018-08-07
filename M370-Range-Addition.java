class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] modify = new int[length];
        if (updates == null || updates.length == 0) return modify;
        for (int[] update : updates) {
            int left = update[0];
            int right = update[1];
            int inc = update[2];
            modify[left] += inc;
            if (right < length - 1) modify[right + 1] -= inc;
        }

        int curr = 0;
        for (int i = 0; i < modify.length; i++) {
            curr += modify[i];
            modify[i] = curr;
        }
        return modify;
    }
}
