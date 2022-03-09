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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        ListNode nextt = head;
        ListNode prev = null;
        
        if(head==null){
            return null;
        }
        
        while( nextt!=null && nextt.next!=null){
            nextt = curr.next;
            if(curr.val==nextt.val){
                
                while(nextt!=null && nextt.val==curr.val){
                    nextt = nextt.next;
                }
                
                if(prev==null){
                    head = nextt;
                    curr = nextt;
                }else{
                    prev.next = nextt;
                    curr = nextt;
                }
                
                
            }else{
                prev = curr;
                curr =nextt;
            }
        }
        
       return head;
    }
}