package interviewProblems.Diameter_Of_Binary_Tree;

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
    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        this.max = 0;
        this.diameterRec(root);
        return this.max - 1;
    }

    private int diameterRec(TreeNode curr) {
        // Base case
        if (curr == null) return 0;
        // Branch out
        int left = diameterRec(curr.left);
        int right = diameterRec(curr.right);
        // Check for storing the max
        max = Math.max(max, left + right + 1);
        return Math.max(left, right) + 1;
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



