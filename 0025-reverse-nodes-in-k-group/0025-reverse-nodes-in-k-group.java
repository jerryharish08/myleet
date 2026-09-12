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
                     if (head == null || k == 1) {
                                 return head;
                                         }
                                         
                                                 ListNode dummy = new ListNode(0);
                                                         dummy.next = head;
                                                         
                                                                 ListNode groupPrev = dummy;
                                                                 
                                                                         while (true) {
                                                                                     // Check if there are at least k nodes left to reverse
                                                                                                 ListNode kth = getKthNode(groupPrev, k);
                                                                                                             if (kth == null) {
                                                                                                                             break;
                                                                                                                                         }
                                                                                                                                         
                                                                                                                                                     ListNode groupNext = kth.next;
                                                                                                                                                                 ListNode prev = groupNext;
                                                                                                                                                                             ListNode curr = groupPrev.next;
                                                                                                                                                                             
                                                                                                                                                                                         // Reverse the current k-group
                                                                                                                                                                                                     while (curr != groupNext) {
                                                                                                                                                                                                                     ListNode tmp = curr.next;
                                                                                                                                                                                                                                     curr.next = prev;
                                                                                                                                                                                                                                                     prev = curr;
                                                                                                                                                                                                                                                                     curr = tmp;
                                                                                                                                                                                                                                                                                 }
                                                                                                                                                                                                                                                                                 
                                                                                                                                                                                                                                                                                             // Connect previous section of list with the newly reversed k-group
                                                                                                                                                                                                                                                                                                         ListNode tmp = groupPrev.next;
                                                                                                                                                                                                                                                                                                                     groupPrev.next = kth;
                                                                                                                                                                                                                                                                                                                                 groupPrev = tmp;
                                                                                                                                                                                                                                                                                                                                         }
                                                                                                                                                                                                                                                                                                                                         
                                                                                                                                                                                                                                                                                                                                                 return dummy.next;
                                                                                                                                                                                                                                                                                                                                                     }
                                                                                                                                                                                                                                                                                                                                                     
                                                                                                                                                                                                                                                                                                                                                         private ListNode getKthNode(ListNode curr, int k) {
                                                                                                                                                                                                                                                                                                                                                                 while (curr != null && k > 0) {
                                                                                                                                                                                                                                                                                                                                                                             curr = curr.next;
                                                                                                                                                                                                                                                                                                                                                                                         k--;
                                                                                                                                                                                                                                                                                                                                                                                                 }
                                                                                                                                                                                                                                                                                                                                                                                                         return curr;
                                                                                                                                                                                                                                                                                                                                                                                                             }
                                                                                                                                                                                                                                                                                                                                                                                                             } 