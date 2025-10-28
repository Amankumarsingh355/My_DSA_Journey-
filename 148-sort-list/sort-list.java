class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode ptr=head;
        List<Integer> list=new ArrayList<>();
        while(ptr!=null){
            list.add(ptr.val);
            ptr=ptr.next;
        }
        Collections.sort(list);
        ListNode n = new ListNode(list.get(0));
        head=n;
        ListNode temp=head;
        for(int i=1;i<list.size();i++){
            ListNode n1 = new ListNode(list.get(i));
            temp.next=n1;
            temp=temp.next;
        }
        return head;
    }
}