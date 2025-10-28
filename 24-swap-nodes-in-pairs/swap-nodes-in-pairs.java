class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null)  return head;
        ListNode fhead = new ListNode(0);
        fhead.next = head;
        ListNode pre = fhead;
        ListNode cur = head;
        ListNode next = head.next;
        
        while(cur != null && next != null) {
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
            
            pre = cur;
            cur = pre.next;
            if (cur == null)
                break;
            next = cur.next;
        }
        return fhead.next;
    }
}