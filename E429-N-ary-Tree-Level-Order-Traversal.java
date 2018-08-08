/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList();
        if (root == null) return res;
        Queue<Node> q = new LinkedList();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList();
            for (int i = 0; i < size; i++) {
                Node curr = q.poll();
                list.add(curr.val);
                for (Node node : curr.children) {
                    q.offer(node);
                }
            }
            res.add(list);
        }
        return res;
    }
}
