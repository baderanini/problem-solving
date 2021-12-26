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
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        
        if(head == null)
            return false;
        
        do {
            slow = slow.next;
            fast = fast.next;
                if(fast == null)
                    return false;
            fast = fast.next;
                if(fast == null)
                    return false;
        } while(slow != fast);
        
        return true;
    }
}