package interviewProblems.Linked_List_Cycle;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // Edge case of no nodes
        if (head == null) return false;
        ListNode fast = head.next, slow = head;
        // If either reaches null, there's no cycle
        while (fast != null && slow != null) {
            if (fast == slow) return true;
            slow = slow.next;
            // Check if there's space to advance fast
            if (fast.next != null) fast = fast.next.next;
            else fast = null;
        }

        return false;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}