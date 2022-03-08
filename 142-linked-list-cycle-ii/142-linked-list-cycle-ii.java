
//O(1) memory solution , using floyd's cycle detection algo
// recommened coding ninjas blog

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
            
            slow = head;
            while(slow!=fast){
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
            
        }
        
       return null;
    }
}