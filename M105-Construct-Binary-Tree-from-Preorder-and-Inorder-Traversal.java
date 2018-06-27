/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;
        return build(preorder, inorder, 0, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int[] inorder, int ps, int is, int ie) {
        if (ps >= preorder.length || is > ie) return null;
        int val = preorder[ps];
        TreeNode root = new TreeNode(val);
        for (int i = is; i <= ie; i++) {
            if (inorder[i] == val) {
                root.left = build(preorder, inorder, ps + 1, is, i - 1);
                root.right = build(preorder, inorder, ps - is + i + 1, i + 1, ie);
                return root;
            }
        }
        return root;
    }
}
