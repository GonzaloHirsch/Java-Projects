package interviewProblems.All_Elements_In_Two_Binary_Search_Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* NOTE: It can be improved with binary search */
class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        // Building the element lists
        ArrayList<Integer> l1 = new ArrayList<>(), l2 = new ArrayList<>();
        this.buildNodeList(root1, l1);
        this.buildNodeList(root2, l2);
        // Merging the lists
        return this.mergeLists(l1, l2);
    }

    private List<Integer> mergeLists(ArrayList<Integer> l1, ArrayList<Integer> l2) {
        List<Integer> res = new ArrayList<>();
        int i1 = 0, i2 = 0, n1 = l1.size(), n2 = l2.size();
        while (i1 < n1 || i2 < n2) {
            // Case of passing one of the lists size
            if (i1 >= n1) res.add(l2.get(i2++));
            else if (i2 >= n2) res.add(l1.get(i1++));
                // Case of being within both lists
            else {
                if (l1.get(i1) <= l2.get(i2)) res.add(l1.get(i1++));
                else res.add(l2.get(i2++));
            }
        }
        return res;
    }

    private void buildNodeList(TreeNode curr, List<Integer> list) {
        if (curr == null) return;
        if (curr.left != null) this.buildNodeList(curr.left, list);
        list.add(curr.val);
        if (curr.right != null) this.buildNodeList(curr.right, list);
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