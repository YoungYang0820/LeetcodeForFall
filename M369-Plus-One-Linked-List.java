/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode plusOne(ListNode head) {
        Stack<ListNode> s = new Stack();
        ListNode curr = head;
        while (curr != null) {
            s.push(curr);
            curr = curr.next;
        }
        while (true) {
            if (s.isEmpty()) {
                ListNode newHead = new ListNode(1);
                newHead.next = head;
                return newHead;
            }
            ListNode last = s.pop();
            if (last.val == 9) {
                last.val = 0;
            }
            else {
                last.val = last.val + 1;
                break;
            }
        }
        return head;
    }
}
