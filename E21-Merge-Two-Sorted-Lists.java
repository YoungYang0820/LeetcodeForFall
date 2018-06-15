/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val > l2.val) return mergeTwoLists(l2, l1);
        ListNode curr = l1;
        while (curr != null) {
            if (l2 == null) return l1;
            if (curr.next == null) {
                curr.next = l2;
                return l1;
            }
            if (curr.val <= l2.val && curr.next.val > l2.val) {
                ListNode tmp = l2;
                l2 = l2.next;
                tmp.next = curr.next;
                curr.next = tmp;
            }
            curr = curr.next;
        }
        return l1;
    }
}
