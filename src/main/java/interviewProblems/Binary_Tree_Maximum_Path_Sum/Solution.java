package interviewProblems.Binary_Tree_Maximum_Path_Sum;

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
    private int max;
    public int maxPathSum(TreeNode root) {
        this.max = Integer.MIN_VALUE;
        this.maxPathRec(root);
        return this.max;
    }

    private int maxPathRec(TreeNode curr) {
        if (curr == null) return 0;
        // Explore both paths
        int left = this.maxPathRec(curr.left);
        int right = this.maxPathRec(curr.right);
        // Check for the new max
        this.max = Math.max(this.max, curr.val + (left > 0 ? 1 : 0) * left + (right > 0 ? 1 : 0) * right);
        // If not worth passing through this node, return the best of the child paths passing through this
        return Math.max(Math.max(left + curr.val, right + curr.val), curr.val);
    }

    // Minor improvements to the solution
    private int maxPathRecImproved(TreeNode curr) {
        if (curr == null) return 0;
        // Explore both paths
        int left = Math.max(this.maxPathRec(curr.left), 0);
        int right = Math.max(this.maxPathRec(curr.right), 0);
        // Check for the new max
        this.max = Math.max(this.max, curr.val + left + right);
        // If not worth passing through this node, return the best of the child paths passing through this
        return Math.max(left + curr.val, right + curr.val);
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
