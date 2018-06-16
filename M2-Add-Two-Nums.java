/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode first = result;
        int val1, val2;
        int add = 0;
        while (add != 0 || l1 != null || l2 != null) {
            val1 = (l1 == null) ? 0 : l1.val;
            val2 = (l2 == null) ? 0 : l2.val;
            l1 = (l1 == null) ? l1 : l1.next;
            l2 = (l2 == null) ? l2 : l2.next;
            ListNode cur = new ListNode((val1 + val2 + add) % 10);
            result.next = cur;
            result = result.next;
            add = (val1 + val2 + add) / 10;
        }
        return first.next;
    }
}
