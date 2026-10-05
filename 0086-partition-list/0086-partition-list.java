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
    public ListNode partition(ListNode head, int x) {
        // Dummy heads to build the two sublists easily
        ListNode beforeHead = new ListNode(0);
        ListNode before = beforeHead;

        ListNode afterHead = new ListNode(0);
        ListNode after = afterHead;

        // Traverse the original list
        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }

        // Break the tail link of the "after" list to avoid cycles
        after.next = null;

        // Connect the "before" list with the "after" list
        before.next = afterHead.next;

        return beforeHead.next;
    }
}