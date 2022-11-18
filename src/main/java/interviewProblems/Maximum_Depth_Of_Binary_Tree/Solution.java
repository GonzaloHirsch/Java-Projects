package interviewProblems.Maximum_Depth_Of_Binary_Tree;

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
    public int maxDepth(TreeNode root) {
        return this.maxDepthRecursive(root, 0);
    }

    private int maxDepthRecursive(TreeNode curr, int depth) {
        if (curr == null) return depth;
        return Math.max(
                this.maxDepthRecursive(curr.left, depth + 1),
                this.maxDepthRecursive(curr.right, depth + 1)
        );
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