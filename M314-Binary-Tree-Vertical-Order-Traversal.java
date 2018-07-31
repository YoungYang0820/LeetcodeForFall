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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) return new ArrayList();
        HashMap<Integer, List<Integer>> map = new HashMap();
        Queue<TreeNode> q = new LinkedList();
        Queue<Integer> q2 = new LinkedList();

        q.offer(root);
        q2.offer(0);
        while (!q.isEmpty() && !q2.isEmpty()) {
            TreeNode node = q.poll();
            int pos = q2.poll();
            List<Integer> list = map.getOrDefault(pos, new ArrayList());
            list.add(node.val);
            map.put(pos, list);
            if (node.left != null) {
                q.offer(node.left);
                q2.offer(pos - 1);
            }
            if (node.right != null) {
                q.offer(node.right);
                q2.offer(pos + 1);
            }
        }
        List<List<Integer>> res = new ArrayList();
        List<Integer> index = new ArrayList(map.keySet());
        Collections.sort(index);
        for (int pos : index) {
            res.add(map.get(pos));
        }
        return res;
    }
}
