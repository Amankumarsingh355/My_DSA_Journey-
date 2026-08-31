class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int first = -1;
        int last = -1;
        int minDistance = Integer.MAX_VALUE;
        int position = 1;
        ListNode prev = head;
        ListNode curr = head.next;
        while (curr != null && curr.next != null) {
            boolean isCritical =
                (curr.val > prev.val && curr.val > curr.next.val) ||
                (curr.val < prev.val && curr.val < curr.next.val);
            if (isCritical) {
                if (first == -1) {
                    first = position;
                } else {
                    minDistance = Math.min(minDistance, position - last);
                }
                last = position;
            }
            prev = curr;
            curr = curr.next;
            position++;
        }
        if (first == -1 || first == last) {
            return new int[]{-1, -1};
        }
        int maxDistance = last - first;
        return new int[]{minDistance, maxDistance};
    }
}