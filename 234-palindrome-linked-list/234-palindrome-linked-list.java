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
    public boolean isPalindrome(ListNode head) {
        ListNode prev = head;
        ListNode slow=head;
        ListNode fast = head;
        ListNode rev=null;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            prev.next = rev;
            rev = prev;
            prev = slow;
        }
        
        if(fast!=null){
            slow = prev.next;
        }
        
        while( slow!=null){
            
            if(rev.val != slow.val){
                return false;
            }
            
            rev = rev.next;
            slow = slow.next;
        }
        
        return true;
    }
}