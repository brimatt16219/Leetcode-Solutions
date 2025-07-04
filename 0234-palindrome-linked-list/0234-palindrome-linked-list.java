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
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<Integer>();

        ArrayList<Integer> list = new ArrayList<Integer>();

        while(head != null) {
            list.add(head.val);
            stack.push(head.val);

            head = head.next;
        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}