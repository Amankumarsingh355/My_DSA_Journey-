public class Solution{
    public Node copyRandomList(Node head){
        if (head == null) return null;
        Node cur = head;
        while (cur != null) {
            Node copy = new Node(cur.val);
            copy.next = cur.next;
            cur.next = copy;
            cur = copy.next;
        }
        cur = head;
        while (cur != null){
            Node copy = cur.next;
            copy.random = (cur.random != null) ? cur.random.next : null;
            cur = copy.next;
        }
        cur = head;
        Node newHead = head.next;
        while (cur != null) {
            Node copy = cur.next;
            cur.next = copy.next;
            cur = cur.next;
            copy.next = (cur != null) ? cur.next : null;
        }
        return newHead;
    }
}