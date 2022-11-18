package interviewProblems.Intersection_Of_Two_Linked_Lists;

import java.util.HashSet;
import java.util.Set;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> nodes = new HashSet<>();

        // Populate with list A
        ListNode curr = headA;
        while (curr != null) {
            nodes.add(curr);
            curr = curr.next;
        }

        // Check on list B
        curr = headB;
        while (curr != null) {
            if (nodes.contains(curr)) return curr;
            curr = curr.next;
        }

        return null;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}