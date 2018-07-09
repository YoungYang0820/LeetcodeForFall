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
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        LinkedList<Integer> res = new LinkedList<>();
        while (!s.isEmpty() || root != null) {
            if (root != null) {
                s.push(root);
                res.addFirst(root.val);
                root = root.right;
            }
            else {
                root = s.pop();
                root = root.left;
            }
        }
        return res;
    }
}
