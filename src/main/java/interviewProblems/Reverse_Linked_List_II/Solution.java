package interviewProblems.Reverse_Linked_List_II;

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
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // Use an array as a stack, size is interval size + 1 given it's not 0-based
        int[] numbers = new int[right - left + 1];
        ListNode n = reverseList(head, numbers, left, right, 1);
        return head;
    }

    // Recursive function that returns the current node
    public ListNode reverseList(ListNode head, int[] numbers, int left, int right, int current) {
        // If not within interval, just pass it
        if (current < left || current > right) {
            // Return the node if no next node
            if (head.next == null) return head;
            // Add the next as the next, shouldn't change, just to keep
            reverseList(head.next, numbers, left, right, current + 1);
            return head;
        } else {
            // Add number to stack in the order we get them
            numbers[current - left] = head.val;
            // Go to next one only if it can
            if (head.next != null) reverseList(head.next, numbers, left, right, current + 1);
            // Recover the number in the opposite end of the stack
            head.val = numbers[right - current];
            return head;
        }
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