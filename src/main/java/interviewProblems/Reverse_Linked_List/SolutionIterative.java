package interviewProblems.Reverse_Linked_List;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class SolutionIterative {
    public ListNode reverseList(ListNode head) {
        // Edge case, no list
        if (head == null) return null;
        // Head is the current one
        ListNode prev = null, next = head.next;
        while (head != null) {
            head.next = prev;
            // Moving on
            prev = head;
            head = next;
            next = head == null ? null : head.next;
        }
        return prev;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}