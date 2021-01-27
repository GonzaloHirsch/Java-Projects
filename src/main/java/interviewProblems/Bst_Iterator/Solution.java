package interviewProblems.Bst_Iterator;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Solution {
    private Iterator<Integer> iter;

    public Solution(TreeNode root) {
        ArrayList<Integer> nodes = new ArrayList<>();
        if (root != null){
            this.build(root, nodes);
        }
        this.iter = nodes.iterator();
    }

    private void build(TreeNode node, ArrayList<Integer> nodes){
        if (node.left != null){
            this.build(node.left, nodes);
        }
        nodes.add(node.val);
        if (node.right != null){
            this.build(node.right, nodes);
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return this.iter.hasNext();
    }

    /** @return the next smallest number */
    public int next() {
        return this.iter.next();
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

/**
 * Your Solution will be called like this:
 * Solution i = new Solution(root);
 * while (i.hasNext()) System.out.print(i.next());
 */

