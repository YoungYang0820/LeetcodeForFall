/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode prev = sentinel;
        ListNode cur = head;
        boolean rep = false;
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                rep = true;
                cur = cur.next;
            }
            if (!rep) {
                prev.next = cur;
                prev = prev.next;
            } else {
                prev.next = cur.next;
            }
            cur = cur.next;
            rep = false;
        }
        return sentinel.next;
    }
}