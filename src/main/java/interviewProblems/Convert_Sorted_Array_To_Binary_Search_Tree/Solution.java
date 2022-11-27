package interviewProblems.Convert_Sorted_Array_To_Binary_Search_Tree;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return this.buildTree(nums, 0, nums.length - 1);
    }

    // Starts at the middle and sets the build tree for the children
    private TreeNode buildTree(int[] nums, int start, int end) {
        // Base case
        if (start > end) return null;
        // Divide by half
        int idx = (start + end) / 2;
        TreeNode node = new TreeNode(nums[idx]);
        node.left = this.buildTree(nums, start, idx - 1);
        node.right = this.buildTree(nums, idx + 1, end);
        return node;
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