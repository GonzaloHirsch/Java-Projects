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
class Solution {
    public ListNode reverseList(ListNode head) {
        return reverseRec(null, head);
    }

    private ListNode reverseRec(ListNode prev, ListNode curr) {
        // Base case, reached the end of the list
        if (curr == null) return prev;
        ListNode next = curr.next;
        curr.next = prev;
        return reverseRec(curr, next);
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}