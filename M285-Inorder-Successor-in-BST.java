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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (p == null) return null;
        if (p.right != null) return findSuccessor(p.right);

        return findNext(root, p);
    }

    private TreeNode findSuccessor(TreeNode root) {
        if (root.left == null) return root;
        return findSuccessor(root.left);
    }

    private TreeNode findNext(TreeNode root, TreeNode p) {
        if (root == p) return null;
        if (root.val < p.val) {
            return findNext(root.right, p);
        }
        else {
            TreeNode left = findNext(root.left, p);
            return left == null ? root : left;
        }
    }
}
