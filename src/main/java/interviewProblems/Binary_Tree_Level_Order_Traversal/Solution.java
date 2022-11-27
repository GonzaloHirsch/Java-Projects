package interviewProblems.Binary_Tree_Level_Order_Traversal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private Map<Integer, List<Integer>> levels;
    private List<Integer> list;

    public List<List<Integer>> levelOrder(TreeNode root) {
        // We don't know the depth, so we use a hashmap for fast level access
        this.levels = new HashMap<>();
        // Explore and fill lists
        this.levelOrderRec(root, 0);
        // Build the response
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < this.levels.size(); i++) res.add(this.levels.get(i));
        return res;
    }

    private void levelOrderRec(TreeNode curr, int level) {
        if (curr == null) return;
        // Explore the depth
        if (curr.left != null) this.levelOrderRec(curr.left, level + 1);
        if (curr.right != null) this.levelOrderRec(curr.right, level + 1);
        // Fill the current list
        this.list = this.levels.getOrDefault(level, new ArrayList<>());
        this.list.add(curr.val);
        this.levels.put(level, this.list);
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
