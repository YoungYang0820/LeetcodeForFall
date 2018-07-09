/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode sentinel = new ListNode(Integer.MIN_VALUE);
        ListNode curr = head;
        while (curr != null) {
            ListNode node = sentinel;
            while (node.next != null && curr.val > node.next.val) {
                node = node.next;
            }
            ListNode next = curr.next;
            curr.next = node.next;
            node.next = curr;
            curr = next;
        }
        return sentinel.next;
    }
}
