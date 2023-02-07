package interviewProblems.Delete_Node_In_A_Linked_List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        // Must move all values given you cannot remove the reference to the given node from the previous one
        while (node.next.next != null) {
            // Overwrite value
            node.val = node.next.val;
            // Advance
            node = node.next;
        }
        // Delete the last node
        node.val = node.next.val;
        node.next = null;
    }

    /*
    public void deleteNode(ListNode node) {
        // Must move all values given you cannot remove the reference to the given node from the previous one
        while (node != null && node.next != null) {
            // Overwrite value
            node.val = node.next.val;
            // Deleting the last node in the list
            if (node.next.next == null) node.next = null;
            // Advance
            node = node.next;
        }
    }
     */

    /*
    public void deleteNode(ListNode node) {
        // Must move all values given you cannot remove the reference to the given node from the previous one
        ListNode prev = node;
        node = node.next;
        while (node != null) {
            // Deleting the last node in the list
            if (node.next == null) prev.next = null;
            // Overwrite value
            prev.val = node.val;
            // Advance
            prev = node;
            node = node.next;
        }
    }
     */
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
