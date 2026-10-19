class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Step 1: Count the total number of nodes in the linked list
        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            length++;
            curr = curr.next;
        }

        // Create a dummy node to act as the head of the sorted list
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Step 2: Iterate by doubling the sublist size (1, 2, 4, 8, ...)
        for (int step = 1; step < length; step *= 2) {
            ListNode prev = dummy;
            curr = dummy.next; // The remaining list to be sorted

            while (curr != null) {
                // Split the first sublist of size 'step'
                ListNode left = curr;
                ListNode right = split(left, step);
                // Split the second sublist of size 'step' and get the remainder
                curr = split(right, step);

                // Merge the two sublists and attach them to the sorted list
                prev.next = merge(left, right);

                // Move 'prev' to the end of the newly merged sublist
                while (prev.next != null) {
                    prev = prev.next;
                }
            }
        }

        return dummy.next;
    }

    // Helper function to split the list into two parts: 
    // takes the first 'step' nodes as one list and returns the head of the rest.
    private ListNode split(ListNode head, int step) {
        if (head == null)
            return null;
        for (int i = 1; i < step && head.next != null; i++) {
            head = head.next;
        }
        ListNode rest = head.next;
        head.next = null; // Break the link
        return rest;
    }

    // Helper function to merge two sorted linked lists
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        tail.next = (l1 != null) ? l1 : l2;
        return dummyHead.next;
    }

}