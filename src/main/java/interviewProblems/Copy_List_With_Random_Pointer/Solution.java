package interviewProblems.Copy_List_With_Random_Pointer;

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

import java.util.HashMap;
import java.util.Map;

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Map<Node, Node> translation = new HashMap<>();

        // Iterate once to create all the translation nodes
        Node newHead = new Node(head.val), curr = head;
        translation.put(head, newHead);
        while (curr != null) {
            if (!translation.containsKey(curr)) translation.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        // Iterate a second time to fill the next/random pointers
        curr = head;
        while (curr != null) {
            if (curr.next != null) translation.get(curr).next = translation.get(curr.next);
            if (curr.random != null) translation.get(curr).random = translation.get(curr.random);
            curr = curr.next;
        }

        return newHead;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}