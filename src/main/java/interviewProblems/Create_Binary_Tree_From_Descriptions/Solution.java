package interviewProblems.Create_Binary_Tree_From_Descriptions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> nodes = new HashMap<>();
        Set<Integer> children = new HashSet<>(descriptions.length);
        // Iterate to populate
        TreeNode child, parent, root = null;
        for (int[] node : descriptions) {
            // Get or create the nodes
            child = nodes.getOrDefault(node[1], new TreeNode(node[1]));
            parent = nodes.getOrDefault(node[0], new TreeNode(node[0]));
            // Set the child
            if (node[2] == 1) parent.left = child;
            else parent.right = child;
            // Store them both
            nodes.put(node[1], child);
            nodes.put(node[0], parent);
            // Store the child info
            children.add(child.val);
        }
        for (Map.Entry<Integer, TreeNode> entry : nodes.entrySet()) {
            if (!children.contains(entry.getKey())) return entry.getValue();
        }
        return null;
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