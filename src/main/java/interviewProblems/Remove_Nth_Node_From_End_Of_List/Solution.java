package interviewProblems.Remove_Nth_Node_From_End_Of_List;

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Determine size of the list in 1 pass
        ListNode curr = head, dummy = new ListNode(0, head), prev = dummy;
        int length = 0, pos = 0;
        while (curr != null) {
            length++;
            curr = curr.next;
        }
        // Add a dummy node to make processing easier
        // Remove in 1 more pass
        curr = head;
        while (curr != null) {
            if (length - pos++ == n) {
                prev.next = curr.next;
                return dummy.next;
            }
            prev = curr;
            curr = curr.next;
        }
        return null;
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