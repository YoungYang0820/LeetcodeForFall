/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private String splitter = ",";
    private String none = "null";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        encode(root, sb);
        return sb.toString();
    }

    private void encode(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(none).append(splitter);
            return;
        }
        sb.append(root.val).append(splitter);
        encode(root.left, sb);
        encode(root.right, sb);
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> q = new LinkedList();
        q.addAll(Arrays.asList(data.split(splitter)));
        return build(q);
    }

    private TreeNode build(Deque<String> nodes) {
        String node = nodes.remove();
        if (node.equals(none)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(node));
        root.left = build(nodes);
        root.right = build(nodes);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
