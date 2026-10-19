/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;

        // Step 1: Create new nodes and interweave them with the original nodes
        Node curr = head;
        while (curr != null) {
            Node nextOriginal = curr.next;
            Node clone = new Node(curr.val);
            curr.next = clone;
            clone.next = nextOriginal;
            curr = nextOriginal;
        }

        // Step 2: Assign random pointers for the cloned nodes
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Step 3: Restore the original list and extract the cloned list
        curr = head;
        Node cloneHead = head.next;
        Node cloneCurr = cloneHead;

        while (curr != null) {
            curr.next = cloneCurr.next;
            curr = curr.next;
            if (curr != null) {
                cloneCurr.next = curr.next;
                cloneCurr = cloneCurr.next;
            }
        }

        return cloneHead;
    }

}