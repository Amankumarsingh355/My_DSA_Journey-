class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow= head;
        ListNode fast = head;
        ListNode prev = null;
        while(fast!=null && fast.next!=null){
            prev = slow;
            slow=slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        return merge(l1,l2);
    }
    public ListNode merge(ListNode l1, ListNode l2){
        ListNode nn = new ListNode();
        ListNode temp = nn;
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        while(temp1!=null && temp2!=null){
            if(temp1.val<temp2.val){
                temp.next = temp1;
                temp = temp.next;
                temp1 = temp1.next;
            }
            else{
                temp.next = temp2;
                temp = temp.next;
                temp2 = temp2.next;
            }
        }
        if(temp1!=null){
            temp.next = temp1;
        }
        else{
            temp.next=temp2;
        }
        return nn.next;
    }
}