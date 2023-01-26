package interviewProblems.Sort_List;


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
    public ListNode sortList(ListNode head) {
        // If list is null or has only 1 element, return
        if (head == null || head.next == null) return head;
        // 2 pointers, turtle/hare, tmp is used to keep track of the middle element
        ListNode fast = head, slow = head, tmp = null;
        while (fast != null && fast.next != null) {
            tmp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // Cut off the list at the middle
        tmp.next = null;
        // Recursively sort and merge halfs
        return merge(sortList(head), sortList(slow));
    }

    private ListNode merge(ListNode a, ListNode b) {
        // Keep track of the head
        ListNode dummy = new ListNode(0), curr = dummy;
        while (a != null && b != null) {
            if (a.val < b.val) {
                curr.next = a;
                a = a.next;
            } else {
                curr.next = b;
                b = b.next;
            }
            curr = curr.next;
        }
        if (a != null) curr.next = a;
        if (b != null) curr.next = b;
        return dummy.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}