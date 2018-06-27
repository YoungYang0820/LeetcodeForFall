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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        helper(root, res, 0);
        return res;
    }

    private void helper(TreeNode root, List<List<Integer>> res, int depth) {
        if (root == null) return;
        if (res.size() <= depth) {
            List<Integer> tmp = new LinkedList<>();
            tmp.add(root.val);
            res.add(tmp);
        }
        else {
            if (depth % 2 == 0) {
                res.get(depth).add(root.val);
            }
            else {
                res.get(depth).add(0, root.val);
            }

        }
        helper(root.left, res, depth + 1);
        helper(root.right, res, depth + 1);
    }
}
