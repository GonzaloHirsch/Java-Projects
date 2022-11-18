package interviewProblems.Vertical_Order_Traversal_Of_A_Binary_Tree;

import java.util.*;

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
    private Map<Integer, Map<Integer, PriorityQueue<Integer>>> sortedNodes;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        this.sortedNodes = new TreeMap<>();
        // Compute recursively
        this.calculateRecursive(root, 0, 0);
        // Build the result
        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<Integer> pq;
        for (Map.Entry<Integer, Map<Integer, PriorityQueue<Integer>>> rowEntry : this.sortedNodes.entrySet()) {
            List<Integer> tmp = new ArrayList<>();
            for (Map.Entry<Integer, PriorityQueue<Integer>> m : rowEntry.getValue().entrySet()) {
                pq = m.getValue();
                while (!pq.isEmpty()) tmp.add(pq.poll());
            }
            res.add(tmp);
        }
        return res;
    }

    private void calculateRecursive(TreeNode current, int row, int col) {
        if (current == null) return;
        // Add the value of the current node
        Map<Integer, PriorityQueue<Integer>> m = this.sortedNodes.getOrDefault(col, new TreeMap<>());
        PriorityQueue<Integer> pq = m.getOrDefault(row, new PriorityQueue<>());
        pq.add(current.val);
        m.put(row, pq);
        this.sortedNodes.put(col, m);
        // Recurse
        if (current.left != null) this.calculateRecursive(current.left, row + 1, col - 1);
        if (current.right != null) this.calculateRecursive(current.right, row + 1, col + 1);
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