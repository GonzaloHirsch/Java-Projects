package interviewProblems.Remove_Zero_Sum_Consecutive_Nodes_From_Linked_List;

import java.util.HashMap;
import java.util.Map;

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
    public ListNode removeZeroSumSublists(ListNode head) {
        // Holds cumulative sum and which node
        Map<Integer, ListNode> sums = new HashMap<>();
        int sum = 0, tempSum;
        ListNode dummy = new ListNode(0, head), current = dummy;
        while (current != null) {
            sum += current.val;
            // Remove all in between
            if (sums.containsKey(sum)) {
                current = sums.get(sum).next;
                tempSum = sum + current.val;
                while (tempSum != sum) {
                    sums.remove(tempSum);
                    current = current.next;
                    tempSum += current.val;
                }
                sums.get(sum).next = current.next;
            } else {
                sums.put(sum, current);
            }
            current = current.next;
        }
        return dummy.next;
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