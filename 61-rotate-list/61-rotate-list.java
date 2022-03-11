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
    public ListNode rotateRight(ListNode head, int k) {
        if(k==0 || head==null) {
            return head;
        }
        ListNode curr = head;
        int size=0;
        while(curr!=null){
            size++;
            curr = curr.next;
        }
        if( k%size==0 || size==0 || size==1){
            return head;
        }
        
        int x = k%size;
        curr = head;
        x = size-x;
        ListNode prev = new ListNode(0);
        while(curr!=null && x>0){
            x--;
            prev = curr;
            curr = curr.next;
        }
        
        prev.next = null;
        ListNode newhead = curr;
        while(curr.next!=null){
            curr = curr.next;
        }
        curr.next = head;
        
        return newhead;
    }
}