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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode evenHead = head, oddHead = head.next, iter = head.next.next;
        ListNode evenIter = evenHead, oddIter = oddHead;
        
        head.next.next = null;
        head.next = null;
        
        boolean even = true;
        while(iter != null) {
            ListNode next = iter.next;
            iter.next = null;
            if(even) {
                evenIter.next = iter;
                evenIter = iter;
            } else {
                oddIter.next = iter;
                oddIter = iter;
            }
            iter = next;
            even = !even;
        }  
        
        evenIter.next = oddHead;
        return evenHead;
    }
}