public class Solution{
    public ListNode reverseKGroup(ListNode head, int k){
        if (head == null || k <= 1) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode groupPrev = dummy;
        while (true){
            ListNode kth = groupPrev;
            for (int i = 0; i < k && kth != null; ++i) kth = kth.next;
            if (kth == null) break;
            ListNode groupStart = groupPrev.next;
            ListNode groupNext = kth.next;
            ListNode prev = groupNext;
            ListNode cur = groupStart;
            while (cur != groupNext){
                ListNode nxt = cur.next;
                cur.next = prev;
                prev = cur;
                cur = nxt;
            }
            groupPrev.next = kth;
            groupPrev = groupStart;
        }
        return dummy.next;
    }
}