package interviewProblems.Find_Elements_In_A_Contaminated_Binary_Tree;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
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
    class FindElements {
        private Set<Integer> elements;

        public FindElements(TreeNode root) {
            this.elements = new HashSet<>();
            this.recover(root, 0);
        }

        private void recover(TreeNode node, int val) {
            // Base case, no node
            if (node == null) return;
            // Recover this node and add it to list
            node.val = val;
            this.elements.add(val);
            // Attempt to recover other nodes
            this.recover(node.left, val * 2 + 1);
            this.recover(node.right, val * 2 + 2);
        }

        public boolean find(int target) {
            return this.elements.contains(target);
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

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
}