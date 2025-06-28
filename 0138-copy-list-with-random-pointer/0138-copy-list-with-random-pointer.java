/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> old = new HashMap<>();
        old.put(null, null);

        Node cur = head;
        while (cur != null) {
            old.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        cur = head;
        while (cur != null) {
            Node copy = old.get(cur);
            copy.next = old.get(cur.next);
            copy.random = old.get(cur.random);
            cur = cur.next;
        }

        return old.get(head);


    }
}