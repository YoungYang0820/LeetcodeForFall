/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode target = sentinel;
        ListNode curr = sentinel;
        int i = -1;
        while (curr != null) {
            if (i >= n) {
                target = target.next;
            } else {
                i++;
            }
            curr = curr.next;
        }

        if (target.next == null) return sentinel.next;
        target.next = target.next.next;
        return sentinel.next;
    }
}
