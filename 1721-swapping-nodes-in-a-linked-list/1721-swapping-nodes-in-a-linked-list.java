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
    public ListNode swapNodes(ListNode head, int k) {
        
      ListNode left = head;
      ListNode right=head;
       
        while(k-->1){
            left = left.next;
        }
        
        ListNode curr = left;
        while(curr.next!=null){
            curr = curr.next;
            right = right.next;
        }
        
        int temp = left.val;
        left.val = right.val;
        right.val = temp;
        
        return head;
    }
}