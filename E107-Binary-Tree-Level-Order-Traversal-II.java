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
    List<List<Integer>> res;
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        res = new ArrayList<>();
        recur(root, 0);
        return res;
    }
    private void recur(TreeNode root, int index) {
        if (root == null)
            return;
        if (res.size() <= index) {
            res.add(0, new ArrayList<Integer>());
        }
        res.get(res.size() - index - 1).add(root.val);
        recur(root.left, index + 1);
        recur(root.right, index + 1);
    }
}
