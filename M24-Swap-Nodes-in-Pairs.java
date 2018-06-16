/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode prev = sentinel;
        ListNode curr = head;
        while (curr != null) {
            if (curr.next == null) return sentinel.next;
            ListNode tmp = curr.next;
            curr.next = tmp.next;
            tmp.next = curr;
            prev.next = tmp;
            prev = curr;
            curr = curr.next;
        }
        return sentinel.next;
    }
}
