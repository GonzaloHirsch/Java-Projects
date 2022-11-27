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

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<Node> stack = new Stack<>();
        Set<Node> explored = new HashSet<>();
        Node curr;
        ListIterator<Node> iter;
        // Initialize the stack
        stack.push(root);
        // Iterate until the stack is empty
        while (!stack.isEmpty()) {
            curr = stack.pop();
            // The node was already explored or it doesn't have children
            if (explored.contains(curr) || curr.children == null) res.add(curr.val);
            else {
                // Add to explored list and back to the stack
                explored.add(curr);
                stack.push(curr);
                // Add all children in reverse order
                iter = curr.children.listIterator(curr.children.size());
                while (iter.hasPrevious()) stack.push(iter.previous());
            }
        }
        return res;
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