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
        
       ListNode head = new ListNode(0);
        ListNode move = head;
        
        while(list1!=null && list2!=null){
            if(list1.val>list2.val){
                move.next = list2;
                move = move.next;
                list2 = list2.next;
            }else if(list1.val<list2.val){
                 move.next = list1;
                move = move.next;
                list1 = list1.next;
            }else{
                 move.next = list2;
                move = move.next;
                list2 = list2.next;
              
            }
        }
        
        while(list1!=null){
             move.next = list1;
                move = move.next;
                list1 = list1.next;
        }
        while(list2!=null){
             move.next = list2;
                move = move.next;
                list2 = list2.next;
        }
        
        return head.next;
    }
}