class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Dummy node to serve as the start of the sorted list
        ListNode dummy = new ListNode(0);
        ListNode curr = head; // Current node to be inserted

        while (curr != null) {
            ListNode prev = dummy;

            // Find the right place to insert the current node
            while (prev.next != null && prev.next.val < curr.val) {
                prev = prev.next;
            }

            // Temporarily store the next node to process
            ListNode nextTemp = curr.next;

            // Insert curr between prev and prev.next
            curr.next = prev.next;
            prev.next = curr;

            // Move to the next node in the original list
            curr = nextTemp;
        }

        return dummy.next;
    }

}