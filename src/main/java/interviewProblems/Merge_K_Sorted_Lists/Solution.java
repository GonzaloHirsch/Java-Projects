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
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode root = null;

        // PriorityQueue as heap for the ordered lists
        PriorityQueue<ListNode> heap = new PriorityQueue<>(new Comparator<ListNode>() {
            public int compare(ListNode ln1, ListNode ln2) {
                return Integer.compare(ln1.val, ln2.val);
            }
        });

        // Adding all the lists
        for (ListNode l : lists) {
            if (l != null)
                heap.add(l);
        }

        if (!heap.isEmpty()) {
            ListNode active = heap.poll();

            root = new ListNode(active.val);

            if (active.next != null) {
                heap.add(active.next);
            }

            ListNode curr = root;

            while (!heap.isEmpty()) {
                active = heap.poll();
                curr.next = new ListNode(active.val);
                curr = curr.next;
                active = active.next;
                if (active != null) {
                    heap.add(active);
                }
            }
        }

        return root;
    }

    public static class ListNode {
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
