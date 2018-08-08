/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
     public Node treeToDoublyList(Node root) {
        if(root == null)
            return null;

        Node left = treeToDoublyList(root.left);
        Node right = treeToDoublyList(root.right);

        root.left = root;
        root.right = root;

        return concatenate(concatenate(left, root), right);

    }

    public Node concatenate(Node left, Node right){
        if(left == null)
            return right;
        if(right == null)
            return left;

        Node leftLast = left.left;
        Node rightLast = right.left;

        leftLast.right = right;
        right.left = leftLast;

        left.left = rightLast;
        rightLast.right = left;

        return left;
    }
}
