package interviewProblems.Sum_Of_Nodes_With_Even_Valued_Grandparent;

class Solution_Alt {
    public int sumEvenGrandparent(TreeNode root) {
        return this.sumRec(root, -1, -1);
    }

    private int sumRec(TreeNode curr, int p, int gp) {
        // Base case
        if (curr == null) return 0;
        // Returning the total sum
        return
                this.sumRec(curr.left, curr.val, p) +
                        this.sumRec(curr.right, curr.val, p) +
                        (gp % 2 == 0 ? curr.val : 0);
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