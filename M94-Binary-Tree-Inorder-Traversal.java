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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> s = new Stack<>();
        if (root == null) return res;
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode curr = s.pop();
            if (curr.right != null) {
                s.push(curr.right);
                curr.right = null;
            }
            if (curr.left == null) {
                res.add(curr.val);
            }
            else {
                s.push(curr);
                s.push(curr.left);
                curr.left = null;
            }
        }
        return res;
    }
}
