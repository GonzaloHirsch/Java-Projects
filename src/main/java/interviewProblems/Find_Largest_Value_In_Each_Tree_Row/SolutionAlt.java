package interviewProblems.Find_Largest_Value_In_Each_Tree_Row;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
class SolutionAlt {
    public List<Integer> largestValues(TreeNode root) {
        // Result list
        List<Integer> result = new ArrayList<>();
        // Handle edge case
        if (root == null) return result;
        // Queue for BFS
        Queue<TreeNode> pending = new LinkedList<>();
        pending.add(root);
        // Iterate for BFS
        int size, max;
        TreeNode curr;
        while (!pending.isEmpty()) {
            size = pending.size();
            max = Integer.MIN_VALUE;
            // Compare level
            for (int i = 0; i < size; i++) {
                curr = pending.poll();
                // Add children
                if (curr.left != null) pending.add(curr.left);
                if (curr.right != null) pending.add(curr.right);
                // Check for maximum
                max = Math.max(max, curr.val);
            }
            // Store max
            result.add(max);
        }
        return result;
    }

    public static class TreeNode {
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