package interviewProblems.Lowest_Common_Ancestor_Of_A_Binary_Tree;


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private TreeNode lca;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.lca = null;
        this.lcaRecursive(root, p.val, q.val);
        return this.lca;
    }

    private TreeNode lcaRecursive(TreeNode curr, int p, int q) {
        // Base case
        if (curr == null) return null;
        // Branch out
        TreeNode left = this.lcaRecursive(curr.left, p, q);
        TreeNode right = this.lcaRecursive(curr.right, p, q);
        // Check for solution
        boolean leftOk = left != null && (left.val == p || left.val == q);
        boolean rightOk = right != null && (right.val == p || right.val == q);
        boolean currOk = (curr.val == p || curr.val == q);
        // Left & right are the nodes we are looking for, so this node is the LCA
        // Left or right is the node, and the current node is the other, this node is the LCA
        if ((leftOk && rightOk) || (currOk && (leftOk || rightOk))) {
            this.lca = curr;
            return null;
        }
        // Current node is ok
        else if (currOk) return curr;
            // Left or right are the correct nodes
        else if (leftOk) return left;
        else if (rightOk) return right;
        return null;
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}