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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList();
        if (root == null) return res;
        if (root.left == null && root.right == null) {
            res.add(root.val + "");
            return res;
        }
        helper(root, res, new ArrayList());
        return res;
    }

    private void helper(TreeNode root, List<String> res, List<Integer> tmp) {
        if (root.left == null && root.right == null) {
            if (tmp.size() > 0) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < tmp.size(); i++) {
                    sb.append(tmp.get(i) + "->");
                }
                sb.append(root.val);
                res.add(sb.toString());
            }
            return;
        }
        tmp.add(root.val);
        if (root.left != null) helper(root.left, res, tmp);
        if (root.right != null) helper(root.right, res, tmp);
        tmp.remove(tmp.size() - 1);
    }
}
