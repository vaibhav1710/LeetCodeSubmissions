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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode();
        ListNode head = null;
      
        int carry = 0;
       
        while(l1!=null || l2!=null || carry!=0){
            int x = 0;
            if(l1==null){
                x += 0;
            }else{
                x += l1.val;
                l1 = l1.next;
            }
            
            if(l2==null){
                x += 0;
            }else{
                x += l2.val;
                l2 = l2.next;
            }
            
            x += carry;
            ListNode curr = new ListNode(0,null);
            curr.val = x%10;
            carry = x/10;
            prev.next = curr;
            prev = curr;
            
            if(head == null){
                head = prev;
            } 
        }
        
        
        
        return head;
    }
}