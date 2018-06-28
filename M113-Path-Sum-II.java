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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        helper(root, sum, new LinkedList<>(), res);
        return res;
    }

    private void helper(TreeNode root, int sum, List<Integer> tmp, List<List<Integer>> res) {
        tmp.add(root.val);
        if (root.left == null && root.right == null) {
            if (sum == root.val) {
                res.add(new LinkedList<>(tmp));
            }
        }
        if (root.left != null) {
            helper(root.left, sum - root.val, tmp, res);
        }
        if (root.right != null) {
            helper(root.right, sum - root.val, tmp, res);
        }
        tmp.remove(tmp.size() - 1);
    }
}
