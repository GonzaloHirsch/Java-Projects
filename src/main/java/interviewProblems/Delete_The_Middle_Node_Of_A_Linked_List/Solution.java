package interviewProblems.Delete_The_Middle_Node_Of_A_Linked_List;

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
    public ListNode deleteMiddle(ListNode head) {
        int target = deleteMiddleRec(head, null, 0);
        return target == 0 ? null : head;
    }

    private int deleteMiddleRec(ListNode head, ListNode prev, int size) {
        if (head == null) return size / 2;
        int target = deleteMiddleRec(head.next, head, size + 1);
        if (size == target && prev != null) prev.next = head.next;
        return target;
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