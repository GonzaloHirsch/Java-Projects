package Min_Depth_Of_Binary_Tree;

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    public int minDepth(TreeNode A) {
        return this.minDepthRec(A);
    }

    public int minDepthRec(TreeNode curr){
        if (curr.left == null && curr.right == null){ return 1; }
        int l = Integer.MAX_VALUE;
        if (curr.left != null){
            l = 1 + this.minDepthRec(curr.left);
        }
        int r = Integer.MAX_VALUE;
        if (curr.right != null){
            r = 1 + this.minDepthRec(curr.right);
        }
        return Math.min(l , r);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
}
