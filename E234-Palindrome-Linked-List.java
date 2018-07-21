/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = reverse(slow.next);
        fast = slow.next;
        slow = head;
        while (fast != null) {
            if (fast.val != slow.val) return false;
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode sentinel = new ListNode(0);
        while (head != null) {
            ListNode tmp = head.next;
            head.next = sentinel.next;
            sentinel.next = head;
            head = tmp;
        }
        return sentinel.next;
    }
}
