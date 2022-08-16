package interviewProblems.Find_Largest_Value_In_Each_Tree_Row;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        // Keeps nodes to visit, start by adding the root
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        Queue<Integer> levels = new LinkedList<>();
        levels.add(0);
        // Iterate
        TreeNode current;
        int previousLevel = 0, currentLevel, max = Integer.MIN_VALUE;
        while (nodes.peek() != null) {
            // Get the current values to work with
            current = nodes.poll();
            currentLevel = levels.poll();
            if (currentLevel == previousLevel) max = Math.max(max, current.val);
                // New level of the tree
            else {
                // Add the max and move on
                result.add(max);
                max = current.val;
            }
            previousLevel = currentLevel;
            // Add the next ones
            if (current.left != null) {
                nodes.add(current.left);
                levels.add(currentLevel + 1);
            }
            if (current.right != null) {
                nodes.add(current.right);
                levels.add(currentLevel + 1);
            }
        }
        // Add the last of the max values
        result.add(max);
        return result;
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