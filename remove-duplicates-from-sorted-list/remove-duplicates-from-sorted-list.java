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
        ListNode temp = head;
        while(temp!=null){
         ListNode curr = temp;
         while(temp!=null && temp.val==curr.val){
             temp = temp.next;
         }
         curr.next = temp;
        }
        return head;
    }
}