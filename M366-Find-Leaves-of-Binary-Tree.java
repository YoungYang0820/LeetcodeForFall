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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        if (root == null) return res;
        helper(root, res);
        return res;
    }

    private int helper(TreeNode root, List<List<Integer>> res) {
        if (root.left == null && root.right == null) {
            if (res.size() == 0) res.add(new ArrayList());
            res.get(0).add(root.val);
            return 1;
        }
        int left = root.left == null ? 0 : helper(root.left, res);
        int right = root.right == null ? 0 : helper(root.right, res);
        int max = Math.max(left, right);
        if (res.size() <= max) res.add(new ArrayList());
        res.get(max).add(root.val);
        return max + 1;
    }
}
