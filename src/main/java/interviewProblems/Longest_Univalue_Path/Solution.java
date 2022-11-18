package interviewProblems.Longest_Univalue_Path;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    int res;

    public int longestUnivaluePath(TreeNode root) {
        this.res = 0;
        this.longestRecursive(root);
        return this.res;
    }

    public int longestRecursive(TreeNode curr) {
        // Base case
        if (curr == null) return 0;

        // Branching
        int left = this.longestRecursive(curr.left);
        int right = this.longestRecursive(curr.right);
        int leftCount = 0, rightCount = 0;
        if (curr.left != null && curr.left.val == curr.val) leftCount = left + 1;
        if (curr.right != null && curr.right.val == curr.val) rightCount = right + 1;

        // Responses
        this.res = Math.max(res, leftCount + rightCount);
        return Math.max(leftCount, rightCount);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}