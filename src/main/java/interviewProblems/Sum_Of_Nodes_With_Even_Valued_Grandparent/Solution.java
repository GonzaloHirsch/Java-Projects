package interviewProblems.Sum_Of_Nodes_With_Even_Valued_Grandparent;

class Solution {
    public int sumEvenGrandparent(TreeNode root) {
        // Initial parent & grandparent are uneven because they don't exist
        return this.computeRecursive(root, 1, 1);
    }

    private int computeRecursive(TreeNode curr, int parent, int grandparent) {
        // Base case
        if (curr == null) return 0;
        // Basic sum, taking into account having a grandparent or not
        int sum = grandparent % 2 == 0 ? curr.val : 0;
        // Branching left & right
        if (curr.left != null) sum += this.computeRecursive(curr.left, curr.val, parent);
        if (curr.right != null) sum += this.computeRecursive(curr.right, curr.val, parent);
        return sum;
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