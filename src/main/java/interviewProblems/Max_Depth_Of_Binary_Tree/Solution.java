package interviewProblems.Max_Depth_Of_Binary_Tree;

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    public int maxDepth(TreeNode A) {
        return this.maxDepthRecursive(A);
    }

    public int maxDepthRecursive(TreeNode act){
        if (act.left == null && act.right == null){
            return 1;
        }
        int leftDepth = 0;
        if (act.left != null){
            leftDepth = 1 + this.maxDepthRecursive(act.left);
        }
        int rightDepth = 0;
        if (act.right != null){
            rightDepth = 1 + this.maxDepthRecursive(act.right);
        }
        return Math.max(leftDepth, rightDepth);
    }

    public static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        public TreeNode(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
}
