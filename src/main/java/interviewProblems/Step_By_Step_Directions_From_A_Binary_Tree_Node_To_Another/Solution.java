package interviewProblems.Step_By_Step_Directions_From_A_Binary_Tree_Node_To_Another;

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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        // Get paths to both nodes
        StringBuilder sbStart = new StringBuilder(), sbDest = new StringBuilder();
        this.getSingleDirections(root, startValue, sbStart);
        this.getSingleDirections(root, destValue, sbDest);
        String start = sbStart.reverse().toString(), dest = sbDest.reverse().toString();
        // Merge them
        int n = Math.min(start.length(), dest.length()), i = 0;
        // Find how many shared steps
        for (; i < n && start.charAt(i) == dest.charAt(i); i++) ;
        start = start.substring(i);
        dest = dest.substring(i);
        return "U".repeat(start.length()) + dest;
    }

    private boolean getSingleDirections(TreeNode current, int target, StringBuilder sb) {
        // Not check for null because we never call it if it's not null
        if (current.val == target) return true;
        // Seek, only if the other one failed, prevents seeking extra
        if (current.left != null && this.getSingleDirections(current.left, target, sb))
            sb.append("L");
        else if (current.right != null && this.getSingleDirections(current.right, target, sb))
            sb.append("R");
        // This means we found something
        return sb.length() > 0;
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