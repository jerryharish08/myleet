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
                     if (head == null || head.next == null || k == 0) {
                                 return head;
                                         }
                                         
                                                 // Step 1: Compute length of the linked list and find tail
                                                         ListNode tail = head;
                                                                 int length = 1;
                                                                         while (tail.next != null) {
                                                                                     tail = tail.next;
                                                                                                 length++;
                                                                                                         }
                                                                                                         
                                                                                                                 // Step 2: Normalize k
                                                                                                                         k = k % length;
                                                                                                                                 if (k == 0) {
                                                                                                                                             return head;
                                                                                                                                                     }
                                                                                                                                                     
                                                                                                                                                             // Step 3: Make the list circular
                                                                                                                                                                     tail.next = head;
                                                                                                                                                                     
                                                                                                                                                                             // Step 4: Find the new tail: (length - k - 1)th node from current head
                                                                                                                                                                                     int stepsToNewTail = length - k;
                                                                                                                                                                                             ListNode newTail = head;
                                                                                                                                                                                                     for (int i = 1; i < stepsToNewTail; i++) {
                                                                                                                                                                                                                 newTail = newTail.next;
                                                                                                                                                                                                                         }
                                                                                                                                                                                                                         
                                                                                                                                                                                                                                 // Step 5: Set the new head and break the circular link
                                                                                                                                                                                                                                         ListNode newHead = newTail.next;
                                                                                                                                                                                                                                                 newTail.next = null;
                                                                                                                                                                                                                                                 
                                                                                                                                                                                                                                                         return newHead;
                                                                                                                                                                                                                                                             }
                                                                                                                                                                                                                                                             } 