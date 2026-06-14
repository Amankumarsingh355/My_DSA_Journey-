class Solution {
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode prev = null;
        while (slow != null) {
            ListNode nextNode = slow.next;
            slow.next = prev;
            prev = slow;
            slow = nextNode;
        }
        int ans = 0;
        ListNode first = head;
        ListNode second = prev;
        while (second != null) {
            ans = Math.max(ans, first.val + second.val);
            first = first.next;
            second = second.next;
        }
        return ans;
    }
}