package Least_Common_Ancestor;

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
    public int lca(TreeNode A, int B, int C) {
        int[] sol = new int[1];
        sol[0] = -1;
        this.lcaRec(A, B, C, sol);
        return sol[0];
    }

    public int lcaRec(TreeNode A, int B, int C, int[] sol){
        int sum = 0;
        if (A.val == B || A.val == C){
            sum += A.val;
        }
        if (A.left != null){
            sum += this.lcaRec(A.left, B, C, sol);
        }
        if (A.right != null){
            sum += this.lcaRec(A.right, B, C, sol);
        }
        if (B == C){
            if (sum == B && sol[0] < 0){ sol[0] = A.val; }
        } else {
            if (sum == B + C && sol[0] < 0){ sol[0] = A.val; }
        }
        return sum;
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
