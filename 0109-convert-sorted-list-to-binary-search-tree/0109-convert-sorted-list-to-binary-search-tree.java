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
/**
 * Definition for a binary tree node.
  * public class TreeNode {
   *     int val;
    *     TreeNode left;
     *     TreeNode right;
      *     TreeNode() {}
       *     TreeNode(int val) { this.val = val; }
        *     TreeNode(int val, TreeNode left, TreeNode right) {
         *         this.val = val;
          *         this.left = left;
           *         this.right = right;
            *     }
             * }
              */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }

        // Find the middle element using slow and fast pointers, 
        // keeping track of the prev node to split the list in half.
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // `slow` is now the middle node. Cut the left half from the middle.
        if (prev != null) {
            prev.next = null;
        }

        // The middle element becomes the root of the BST
        TreeNode root = new TreeNode(slow.val);

        // If slow was the head (e.g., list of length 2), head.left is null
        if (head != slow) {
            root.left = sortedListToBST(head);
        }
        root.right = sortedListToBST(slow.next);

        return root;
    }
}