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
    public ListNode rotateRight(ListNode head, int n) {
        ListNode temp = head;
        int len = 0;
        if(n==0){
            return head;
        }
        if(head==null){
            return null;
        }
        while(temp.next!=null){
            temp = temp.next;
            len++;
        }
        int k = 0;
        n = n % (len + 1);
        k = len - n +1 ;    
        if(k==0){
            return head;
        }
        temp.next = head;
        int i = 0;
        temp = head;
        while(i<k-1){
            temp = temp.next;
            i++;
        }
        ListNode shead = temp.next;
        temp.next = null;
        return shead;
    }
}