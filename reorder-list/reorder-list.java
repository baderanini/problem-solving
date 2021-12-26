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
    public void reorderList(ListNode head) {
        ListNode fast = head, slow = head, prev = null;
        
        if(head == null || head.next == null)
            return;
        
        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode secondPart = slow;
        prev.next = null;
        ListNode reversedSecondPart = reverse(secondPart);
        
        ListNode resIter = head;
        ListNode secondPartIter = reversedSecondPart;
        while(resIter != null) {
            ListNode temp = resIter.next;
            resIter.next = secondPartIter;
            ListNode secondPartTemp = secondPartIter.next;
            if(temp != null)
                secondPartIter.next = temp;
            secondPartIter = secondPartTemp;
            resIter = temp;
        }
    }
    
    ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode iter = head;
        while(iter != null) {
            ListNode temp = iter.next;
            iter.next = prev;
            prev = iter;
            iter = temp;
        }
        
        return prev;
    }
}