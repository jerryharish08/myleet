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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {
        // If both nodes are null, they match symmetrically
        if (t1 == null && t2 == null) {
            return true;
        }

        // If one is null or values don't match, it's not symmetric
        if (t1 == null || t2 == null || t1.val != t2.val) {
            return false;
        }

        // A tree is symmetric if the left subtree of the left child 
        // mirrors the right subtree of the right child, and vice versa.
        return isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }
}