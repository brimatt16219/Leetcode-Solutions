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
    public ListNode deleteMiddle(ListNode head) {

        if (head.next == null) return null;
        ListNode curr = head;
        ListNode temp = curr;
        
        int count = 0;
        while (head != null) {
            head = head.next;
            count ++;
        }

        for (int i = 0; i < count / 2 - 1; i++) {
            curr = curr.next;
        }

        curr.next = curr.next.next; 
        
        return temp;
    }
}