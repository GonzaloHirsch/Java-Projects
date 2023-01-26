package interviewProblems.Merge_K_Sorted_Lists;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Solution_Alt {
    public ListNode mergeKLists(ListNode[] lists) {
        // Fill the pq
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.val, b.val));
        for (ListNode list : lists) if (list != null) pq.add(list);

        // Init the head
        ListNode head = pq.peek(), prev = null, curr = null;

        while (!pq.isEmpty()) {
            curr = pq.poll();
            // Modify the list
            if (prev != null) prev.next = curr;
            prev = curr;
            // Add back
            if (curr.next != null) pq.add(curr.next);
        }

        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
