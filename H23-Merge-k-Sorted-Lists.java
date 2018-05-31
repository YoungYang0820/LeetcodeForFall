/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        if (lists.length == 2) return mergeTwoLists(lists[0], lists[1]);
        return mergeTwoLists(mergeKLists(Arrays.copyOfRange(lists, 0, lists.length/2)),
                            mergeKLists(Arrays.copyOfRange(lists, lists.length/2, lists.length)));
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
