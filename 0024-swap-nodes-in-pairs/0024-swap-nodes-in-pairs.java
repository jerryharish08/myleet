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
             public ListNode swapPairs(ListNode head) {
                     // Dummy node to simplify edge cases like swapping the head pair
                             ListNode dummy = new ListNode(0);
                                     dummy.next = head;
                                     
                                             ListNode current = dummy;
                                             
                                                     // Traverse while there are at least two nodes left to swap
                                                             while (current.next != null && current.next.next != null) {
                                                                         ListNode first = current.next;
                                                                                     ListNode second = current.next.next;
                                                                                     
                                                                                                 // Re-point references to swap first and second
                                                                                                             first.next = second.next;
                                                                                                                         second.next = first;
                                                                                                                                     current.next = second;
                                                                                                                                     
                                                                                                                                                 // Move current forward by two nodes for the next pair
                                                                                                                                                             current = first;
                                                                                                                                                                     }
                                                                                                                                                                     
                                                                                                                                                                             return dummy.next;
                                                                                                                                                                                 }
                                                                                                                                                                                 } 