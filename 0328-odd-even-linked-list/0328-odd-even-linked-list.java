/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode oddHead  = head;
        ListNode evenHead = head.next;
        ListNode odd      = oddHead;
        ListNode even     = evenHead;

        while (even != null && even.next != null) {
            // link next odd
            odd.next  = even.next;
            odd       = odd.next;
            // link next even
            even.next = odd.next;
            even      = even.next;
        }

        odd.next = evenHead;
        return oddHead;
    }
}