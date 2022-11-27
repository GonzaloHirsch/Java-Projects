package interviewProblems.Add_Two_Numbers_II;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Filling the stacks
        Stack<Integer> s1 = new Stack<>(), s2 = new Stack<>();
        this.fillStack(l1, s1);
        this.fillStack(l2, s2);

        // Processing the stacks
        ListNode curr = null, prev = null;
        int sum = 0, carry = 0;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            // Compute sum
            sum = carry;
            if (!s1.isEmpty()) sum += s1.pop();
            if (!s2.isEmpty()) sum += s2.pop();
            // Create node
            curr = new ListNode(sum % 10, prev);
            prev = curr;
            // Calculate carry
            carry = sum / 10;
        }

        // Leftover carry creates a new node
        if (carry > 0) curr = new ListNode(carry, prev);

        return curr;
    }

    private void fillStack(ListNode l, Stack<Integer> stack) {
        ListNode curr = l;
        while (curr != null) {
            stack.push(curr.val);
            curr = curr.next;
        }
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}