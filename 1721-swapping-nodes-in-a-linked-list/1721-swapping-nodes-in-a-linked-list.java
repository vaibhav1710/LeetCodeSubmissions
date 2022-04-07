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
        
        int temp = k;
        ListNode a = null;
        ListNode b = null;
        
        ListNode cur = head;
        while(k>1){
            cur = cur.next;
            k--;
        }
        a = cur;
        int s=k;
        while(cur.next!=null){
            cur  = cur.next;
            s++;
        }
        int v = s-k+1;
        cur = head;
        while(v>1){
            cur = cur.next;
            v--;
        }
        b = cur;
        temp = a.val;
        a.val = b.val;
        b.val = temp;
        
        return head;
    }
}