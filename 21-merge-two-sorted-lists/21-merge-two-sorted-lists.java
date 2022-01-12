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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null && list2==null){
            return null;
        } 
        
        ListNode head=null;
        ListNode first = null;
        ListNode second = null;
         if(list1!=null && list2!=null){
        if(list1.val>list2.val){
            head = list2;
             first = list1;
            second = list2.next;
        }else{
            first = list1.next;
            head = list1;
            second = list2;
        }
         }else if(list1==null){
             head = list2;
             second = list2.next;
         }else{
             head=list1;
             first = list1.next;
         }
        
    
        
        
        ListNode move = head;
        
        while(first!=null || second!=null){
            
            if(first!=null && second!=null){
                if(first.val>second.val){
                    move.next = second;
                    move = move.next;
                    second = second.next;
                }else{
                      move.next = first;
                    move = move.next;
                    first = first.next;
                }
            }else if(first!=null){
                  move.next = first;
                    move = move.next;
                    first = first.next;   
            }else{
                 move.next = second;
                    move = move.next;
                    second = second.next;
            }
             
        }
        
        return head;
        
        
    }
}