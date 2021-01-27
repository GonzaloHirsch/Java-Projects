package interviewProblems.Valid_Binary_Search_Tree;

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
    public int isValidBST(TreeNode A) {
        return this.isValidRecursive(A, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public int isValidRecursive(TreeNode A, int min, int max){
        if (A == null){ return 1; }
        if (A.val < max && A.val > min && this.isValidRecursive(A.left, min, A.val) == 1 && this.isValidRecursive(A.right, A.val, max) == 1){
            return 1;
        }
        return 0;
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
