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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode forward = head, back = head;
        
        if(head == null)
            return null;
        ListNode iter = head;
        int size = 0;
        while(iter != null) {
            size++;
            iter = iter.next;
        }
        
        k = k%size;
        
        if(k == 0)
            return head;
        
        for(int i = 0 ; i < k ; i++) {
            forward = forward.next;
        }
        
        while(forward.next != null) {
            forward = forward.next;
            back = back.next;
        }
        
        ListNode newHead = back.next;
        back.next = null;
        forward.next = head;
        
        return newHead;   
    }
}