/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        ListNode curr = head;
        int len = 0;
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        k = len - k % len;
        if (k == 0) return head;
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        len = 1;
        curr = head;
        while (curr != null) {
            if (len == k) break;
            curr = curr.next;
            len++;
        }

        ListNode curr2 = curr;

        while (curr2.next != null) {
            curr2 = curr2.next;
        }
        curr2.next = head;
        sentinel.next = curr.next;
        curr.next = null;
        return sentinel.next;

    }
}
