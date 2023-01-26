package interviewProblems.Add_Two_Numbers;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class SolutionAlternative {
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(0), curr = dummy;
            int num = 0, carry = 0;
            while (l1 != null || l2 != null) {
                // Compute number
                num = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
                carry = num / 10;
                // New list node
                curr.next = new ListNode(num % 10);
                // Advance lists
                curr = curr.next;
                l1 = (l1 != null ? l1.next : null);
                l2 = (l2 != null ? l2.next : null);
            }
            // Check for carry
            if (carry > 0) curr.next = new ListNode(carry);
            return dummy.next;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}