package Level_Order;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * Definition for binary tree
 * class TreeNode {
 *      int val;
 *      TreeNode left;
 *      TreeNode right;
 *      TreeNode(int x) {
 *          val = x;
 *          left=null;
 *          right=null;
 *      }
 * }
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> sol = new ArrayList<>();
        ArrayDeque<TreeNode> actual = new ArrayDeque<>();
        actual.add(A);
        ArrayDeque<TreeNode> next = new ArrayDeque<>();
        TreeNode curr;
        while (actual.peek() != null) {
            ArrayList<Integer> currSol = new ArrayList<>();
            curr = actual.poll();
            while (curr != null) {
                currSol.add(curr.val);
                if (curr.left != null) {
                    next.add(curr.left);
                }
                if (curr.right != null) {
                    next.add(curr.right);
                }
                curr = actual.poll();
            }
            actual = next;
            next = new ArrayDeque<>();
            sol.add(currSol);
        }
        return sol;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }
}

