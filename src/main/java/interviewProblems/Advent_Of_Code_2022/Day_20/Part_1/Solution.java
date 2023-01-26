package interviewProblems.Advent_Of_Code_2022.Day_20.Part_1;

public class Solution {
    public int findCoordinates(String input) {
        // Get the list nodes
        ListNode[] nodes = this.getList(input);
        ListNode zero = null, curr;
        // Move the nodes
        for (ListNode node : nodes) {
            // Find the zero node
            if (node.val == 0) {
                zero = node;
                continue;
            }
            // Attempt to move the node
            curr = node;
            // Find the new position
            int target = node.val > 0 ? node.val % nodes.length : (node.val % nodes.length) + nodes.length - 1;
            //if (node.val > 0) for (int i = 0; i < node.val % nodes.length; i++) curr = curr.next;
            for (int i = 0; i < target; i++) curr = curr.next;
            //else for (int i = 0; i >= node.val % nodes.length; i--) curr = curr.prev;
            if (curr == node) continue;
            // Remove this node
            node.prev.next = node.next;
            node.next.prev = node.prev;
            // Add it later
            node.prev = curr;
            node.next = curr.next;
            curr.next.prev = node;
            curr.next = node;
        }
        // Compute
        int total = 0;
        curr = zero;
        for (int i = 0; i <= 3000; i++) {
            if (i == 1000 || i == 2000 || i == 3000) total += curr.val;
            curr = curr.next;
        }
        return total;
    }

    public ListNode[] getList(String input) {
        String[] lines = input.split("\n");
        ListNode[] nodes = new ListNode[lines.length];
        ListNode curr = new ListNode(Integer.MIN_VALUE);
        for (int i = 0; i < lines.length; i++) {
            curr.next = new ListNode(Integer.parseInt(lines[i]));
            curr.next.prev = curr;
            curr = curr.next;
            nodes[i] = curr;
        }
        // Make the list circular by having the nodes connect
        nodes[0].prev = nodes[nodes.length - 1];
        nodes[nodes.length - 1].next = nodes[0];
        return nodes;
    }

    public static class ListNode {
        public int val;
        public ListNode next;
        public ListNode prev;
        public ListNode(int val) {
            this.val = val;
        }
        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}