package interviewProblems.Odd_Even_Linked_List;
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
    public ListNode oddEvenList(ListNode head) {
        // Base case of up to 1 node
        if (head == null || head.next == null) return head;
        ListNode dummyEven = new ListNode(0), dummyOdd = new ListNode(0), curr = head, tmp;
        ListNode[] nodes = new ListNode[]{dummyEven, dummyOdd};
        int i = 1;
        while (curr != null) {
            // Keep copy of next to avoid losing it
            tmp = curr.next;
            nodes[i % 2].next = curr;
            nodes[i % 2] = nodes[i % 2].next;
            curr.next = null;
            curr = tmp;
            i++;
        }

        // Find the end of the odd list
        curr = dummyOdd;
        while (curr.next != null) curr = curr.next;
        curr.next = dummyEven.next;

        return dummyOdd.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}