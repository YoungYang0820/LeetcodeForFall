class Solution {
    public boolean verifyPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) return true;
        int low = Integer.MIN_VALUE;
        int i = -1;
        for (int node : preorder) {
            if (node < low) return false;
            while (i >= 0 && node > preorder[i]) low = preorder[i--];
            preorder[++i] = node;
        }
        return true;
    }
}
