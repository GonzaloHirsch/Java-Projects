package interviewProblems.N_Ary_Tree_Postorder_Traversal;

import java.util.*;

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class SolutionAlt {
    private List<Integer> result;

    public List<Integer> postorder(Node root) {
        this.result = new ArrayList<>();
        if (root != null) this.postorderRec(root);
        return this.result;
    }

    private void postorderRec(Node curr) {
        // Explore children if it has
        if (curr.children != null) curr.children.forEach(this::postorderRec);
        // Add to results
        this.result.add(curr.val);
    }
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}

/*
class Solution {
    List<Integer> res;
    public List<Integer> postorder(Node root) {
        this.res = new ArrayList<>();
        this.postorderRec(root);
        return this.res;
    }

    private void postorderRec(Node curr) {
        if (curr == null) return;
        for (Node node : curr.children) this.postorderRec(node);
        this.res.add(curr.val);
    }
}
*/