package interviewProblems.Count_Good_Nodes_In_Binary_Tree;
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
    public int goodNodes(TreeNode root) {
        return countGood(root, Integer.MIN_VALUE);
    }

    public int countGood(TreeNode current, int max) {
        // Break condition
        if (current.left == null && current.right == null) return current.val >= max ? 1 : 0;
        int left = 0, right = 0;
        // Branching left, passing the current maximum for the path
        if (current.left != null) left = countGood(current.left, current.val >= max ? current.val : max);
        // Branching right, passing the current maximum for the path
        if (current.right != null) right = countGood(current.right, current.val >= max ? current.val : max);
        // Return number of good nodes left + right + counting if this node is good
        return right + left + (current.val >= max ? 1 : 0);
    }

      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
     }

}