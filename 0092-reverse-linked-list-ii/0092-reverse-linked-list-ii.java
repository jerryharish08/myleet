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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;

        // Step 1: Move prev to the node right before the `left` position
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        // Step 2: Reverse sublist from `left` to `right`
        ListNode curr = prev.next;
        for (int i = 0; i < right - left; i++) {
            ListNode nextTemp = curr.next;
            curr.next = nextTemp.next;
            nextTemp.next = prev.next;
            prev.next = nextTemp;
        }

        return dummy.next;
    }
}