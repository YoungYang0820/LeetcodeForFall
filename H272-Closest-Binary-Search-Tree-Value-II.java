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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        LinkedList<Integer> res = new LinkedList<>();
        collect(root, target, k, res);
        return res;
    }

    private void collect(TreeNode node, double target, int k, LinkedList<Integer> res) {
        if (node == null)
            return;
        collect(node.left, target, k, res);
        if(res.size() == k) {
            if(Math.abs(node.val - target) < Math.abs(target - res.peekFirst()))
                res.pollFirst();
            else
                return;
        }
        res.add(node.val);
        collect(node.right, target, k, res);
    }
}
