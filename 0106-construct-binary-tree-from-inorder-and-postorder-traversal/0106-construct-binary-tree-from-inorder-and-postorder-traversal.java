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
    private int postorderIndex;
    private Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postorderIndex = postorder.length - 1;

        // Cache the indices of the inorder array for O(1) lookups
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return helper(inorder, postorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] inorder, int[] postorder, int left, int right) {
        // If there are no elements to construct the subtree, return null
        if (left > right) {
            return null;
        }

        // Get the current root value from the postorder traversal and decrement the index
        int rootVal = postorder[postorderIndex--];
        TreeNode root = new TreeNode(rootVal);

        // Find the index of this root in the inorder traversal to divide left and right subtrees
        int mid = inorderMap.get(rootVal);

        // Recursively build the right subtree first because postorder visits Left -> Right -> Root,
        // meaning going backwards through postorder gives us Root -> Right -> Left
        root.right = helper(inorder, postorder, mid + 1, right);
        root.left = helper(inorder, postorder, left, mid - 1);

        return root;
    }
}