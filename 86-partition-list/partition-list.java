class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode lessDummy = new ListNode(0);
        ListNode greaterDummy = new ListNode(0);
        ListNode less = lessDummy, greater = greaterDummy;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                less.next = cur;
                less = less.next;
            } else {
                greater.next = cur;
                greater = greater.next;
            }
            cur = cur.next;
        }
        greater.next = null;
        less.next = greaterDummy.next;
        return lessDummy.next;
    }
}