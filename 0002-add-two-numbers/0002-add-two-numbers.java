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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode temp = new ListNode();
        ListNode curr = temp;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null ? l1.val : 0);
            int y = (l2 != null ? l2.val : 0);

            int sum = x + y + carry;

            curr.next = new ListNode(sum % 10);
            carry = sum / 10;

            curr = curr.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return temp.next;

        
        // List<Integer> n1 = new ArrayList<Integer>();
        // List<Integer> n2 = new ArrayList<Integer>();
        
        // while(l1 != null) {
        //     n1.add(l1.val);

        //     l1 = l1.next;
        // }

        // while(l2 != null) {
        //     n2.add(l2.val);

        //     l2 = l2.next;
        // }

        // System.out.println(n1);
        // System.out.println(n2);

        // // ListNode s = new ListNode();

        // // int len = Math.max(n1.size(), n2.size());
        // List<Integer> s = new ArrayList<Integer>();

        // int carry = 0;

        // int i = n1.size() - 1;
        // int j = n2.size() - 1;

        // while (i >= 0 || j >= 0 || carry != 0) {
        //     int x = (i >= 0 ? n1.get(i) : 0);
        //     int y = (j >= 0 ? n2.get(j) : 0);
        //     int sum = x + y + carry;

        //     s.addFirst(sum % 10);
        //     carry = sum / 10;

        //     i--;
        //     j--;

        // }

        // int k = s.size() - 1;
        // ListNode sol = new ListNode();
        // ListNode temp = sol;

        // while (k >= 0) {
        //     System.out.println("adding " + s.get(k));
        //     sol.val = s.get(k);
        //     if (k > 0) sol.next = new ListNode();
        //     sol = sol.next;
        //     k--;
        // }
        
        // System.out.println(s);
        // return temp;
    }
}