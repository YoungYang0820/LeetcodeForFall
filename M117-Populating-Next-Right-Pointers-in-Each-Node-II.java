/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        while(root!=null) {
            TreeLinkNode head=new TreeLinkNode(0),end=head;
            while(root!=null) {
                if(root.left!=null) {
                    end.next=root.left;
                    end=root.left;
                }
                if(root.right!=null) {
                    end.next=root.right;
                    end=root.right;
                }
                root=root.next;
            }
            root=head.next;
        }
    }
}
