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
        ListNode slow = head, fast = head;
        
        if(head == null)
            return null;
        
        
        do {
            slow = slow.next;
            if(fast == null)
                return null;
            fast = fast.next;
            if(fast == null)
                return null;
            fast = fast.next;
        } while(fast != slow);
        
        
        ListNode iter = head;
        
        while(slow != iter) {
            iter = iter.next;
            slow = slow.next;
        }
        
        return iter;
    }
}