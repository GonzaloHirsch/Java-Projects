package interviewProblems.Kth_Smallest_Element_In_A_Bst;


import java.util.Arrays;

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
    private int count = 0, result = 0;

    public int kthSmallest(TreeNode root, int k) {
        this.count = k;
        this.smallestRec(root);
        return this.result;
    }

    private void smallestRec(TreeNode curr) {
        if (curr == null || this.count <= 0) return;
        smallestRec(curr.left);
        if (--this.count == 0) this.result = curr.val;
        smallestRec(curr.right);
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