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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        List<Integer> list = new ArrayList<Integer>();
        System.out.println(list);
        
        for (int i = 0; i < lists.length; i++)
        {
            if (lists[i] != null)
            {
                ListNode temp = lists[i];
                while(temp != null)
                {
                    System.out.println("Adding!");
                    list.add(temp.val);
                    temp = temp.next;
                }
            }
        }
        if (list.size() == 0) return null;
        Collections.sort(list);
        System.out.println(list);
        
        ListNode head = new ListNode();
        ListNode temp = head;
        for (int i = 0; i < list.size(); i++)
        {
            head.val = list.get(i);
            if (i < list.size() - 1){
                head.next = new ListNode();
                head = head.next;
            }
            
        }
        return temp;
    }
}