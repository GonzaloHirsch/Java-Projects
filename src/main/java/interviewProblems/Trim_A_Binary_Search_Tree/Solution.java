package interviewProblems.Trim_A_Binary_Search_Tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        return this.trimRecursive(root, low, high);
    }

    private TreeNode trimRecursive(TreeNode curr, int low, int high) {
        // Base case
        if (curr == null) return null;
        // Check if the node itself needs trimming
        if (curr.val < low) return this.trimRecursive(curr.right, low, high);
        if (curr.val > high) return this.trimRecursive(curr.left, low, high);
        curr.left = this.trimRecursive(curr.left, low, high);
        curr.right = this.trimRecursive(curr.right, low, high);
        return curr;
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
