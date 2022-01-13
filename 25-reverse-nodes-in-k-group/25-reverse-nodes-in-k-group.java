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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode iter = head, prev = null;
        
        ListNode sizeIter = head;
        
        int size = 0;
        while(sizeIter != null) {
            size++;
            sizeIter = sizeIter.next;
        }
        
        size = size/k*k;
        
        if(size == 1 || k == 1)
            return head;
        
        int counter = 1;
        ListNode res = head;
        ListNode subPrev = null, subStart = null;
        int index = 0;
        while(iter != null) {
            index++;
            if(index > size)
                break;
            if(counter == 1) {
                subStart = iter;
                subPrev = prev;
                prev = iter;
                iter = iter.next;
            } else {
                ListNode next = iter.next;
                iter.next = prev;
                prev = iter;
                iter = next;
                
                if(counter == k) {
                    if(subPrev != null) {
                        subPrev.next = prev;
                    } else {
                        res = prev;
                    }
                    prev = subStart;
                    subStart.next = next;
                    counter = 0;
                }
            }
            counter++;
        }
        
        return res;
    }
}



// ---->  <--- --->