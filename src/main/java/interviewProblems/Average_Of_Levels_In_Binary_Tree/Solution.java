package interviewProblems.Average_Of_Levels_In_Binary_Tree;

import java.util.*;

class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        // Will store results
        List<Double> result = new ArrayList<>();

        // Keep list of pending nodes for BFS
        Queue<TreeNode> pending = new LinkedList<>();
        pending.add(root);

        int size = 0;
        double sum = 0;
        TreeNode curr;

        // This will iterate per level
        while (!pending.isEmpty()) {
            sum = 0;
            size = pending.size();

            // Within a level we iterate all nodes
            for (int i = 0; i < size; i++) {
                // Get the node
                curr = pending.poll();
                // Count for average
                sum += curr.val;
                // Add children to queue
                if (curr.left != null) pending.add(curr.left);
                if (curr.right != null) pending.add(curr.right);
            }
            // Once finished with level, add to result
            result.add(sum / size);
        }

        return result;
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