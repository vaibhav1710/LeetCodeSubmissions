/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        int count=1;
        
        ListNode slow = head;
        ListNode fast = head;
        boolean f = false;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow==fast){
                f = true;
                break;
            }
        }
        
        if(f){
             count = 0;
            fast = head; 
            HashMap<ListNode,Integer> hm = new HashMap<>();
            
            while(fast!=null){
                if(hm.containsKey(fast)){
                    int v = hm.get(fast);
                    return fast;
                }else{
                    hm.put(fast,count);
                    fast = fast.next;
                    count++; 
                }
            }
            
            
        }
      
        return null;
    }
}