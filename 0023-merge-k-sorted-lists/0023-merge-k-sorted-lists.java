import java.util.PriorityQueue;

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
             public ListNode mergeKLists(ListNode[] lists) {
                     if (lists == null || lists.length == 0) {
                                 return null;
                                         }

                                                 // Min-heap ordered by the node's value
                                                         PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

                                                                 // Add the head of each non-null list to the min-heap
                                                                         for (ListNode node : lists) {
                                                                                     if (node != null) {
                                                                                                     minHeap.add(node);
                                                                                                                 }
                                                                                                                         }

                                                                                                                                 ListNode dummy = new ListNode(-1);
                                                                                                                                         ListNode current = dummy;

                                                                                                                                                 // Process nodes from the heap
                                                                                                                                                         while (!minHeap.isEmpty()) {
                                                                                                                                                                     ListNode smallestNode = minHeap.poll();
                                                                                                                                                                                 current.next = smallestNode;
                                                                                                                                                                                             current = current.next;

                                                                                                                                                                                                         // If the extracted node has a next node, push it into the heap
                                                                                                                                                                                                                     if (smallestNode.next != null) {
                                                                                                                                                                                                                                     minHeap.add(smallestNode.next);
                                                                                                                                                                                                                                                 }
                                                                                                                                                                                                                                                         }

                                                                                                                                                                                                                                                                 return dummy.next;
                                                                                                                                                                                                                                                                     }
                                                                                                                                                                                                                                                                     }