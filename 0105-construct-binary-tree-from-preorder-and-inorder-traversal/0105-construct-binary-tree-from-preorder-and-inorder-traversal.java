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
    private int preorderIndex = 0;
    private Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Store the indices of the inorder array in a map for quick root lookup
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return helper(preorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int left, int right) {
        // If there are no elements to construct the subtree, return null
        if (left > right) {
            return null;
        }

        // Get the current root value from the preorder traversal and advance the index
        int rootVal = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootVal);

        // Find the index of this root in the inorder traversal to divide left and right subtrees
        int mid = inorderMap.get(rootVal);

        // Recursively build the left and right subtrees
        // Note: The left subtree must be built before the right subtree because 
        // preorder traversal visits Root -> Left -> Right
        root.left = helper(preorder, left, mid - 1);
        root.right = helper(preorder, mid + 1, right);

        return root;
    }
}