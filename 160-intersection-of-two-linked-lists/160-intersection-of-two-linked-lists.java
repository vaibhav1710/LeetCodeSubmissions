/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> h = new HashSet();
        if(headA==headB){
            return headA;
        }
        h.add(headA);
        h.add(headB);
        boolean f = false;
        while(!f && headA!=null && headB!=null){
            
            headA = headA.next;
            headB = headB.next;
            
            if(headA==headB){
                return headA;
            }
            else{
                if(headA!=null && h.contains(headA)){
                    return headA;
                }
                if(headB!=null && h.contains(headB)){
                    return headB;
                }
                h.add(headA);
                h.add(headB);
            }
        }
        
        while(headA!=null && headA.next!=null){
            headA  = headA.next;
            if(h.contains(headA)){
                return headA;
            }
        } 
        
         while(headB!=null && headB.next!=null){
            headB  = headB.next;
            if(h.contains(headB)){
                return headB;
            }
        }
        
        return null;
        
        
    }
}