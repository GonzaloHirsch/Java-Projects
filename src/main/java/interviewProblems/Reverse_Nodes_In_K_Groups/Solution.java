package interviewProblems.Reverse_Nodes_In_K_Groups;

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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) return head;

        ListNode curr = head, prev = null, cacheHead = head, prevCacheHead = null, cacheTail = null, ret = head;
        int count = 0, times = 0;
        while (curr != null) {
            count++;
            // Reverse part
            if (count % k == 0) {
                // Reset count
                count = 0;
                // Store the next item of the list
                cacheTail = curr.next;
                // Delete link to that last item to get isolated list
                curr.next = null;
                // Revert the list
                this.reverseList(cacheHead);
                // Link the reversed list to the item stored before
                cacheHead.next = cacheTail;

                // Store the response the first time
                if (times == 0) {
                    ret = curr;
                } else if (prevCacheHead != null) {
                    prevCacheHead.next = curr;
                }
                times++;

                // Set the current as the last item of the reversed list
                curr = cacheHead;
                // Cache the head used
                prevCacheHead = cacheHead;
                // Cache the new next head
                cacheHead = cacheTail;
            }
            prev = curr;
            curr = curr.next;
        }

        return ret;
    }

    private void reverseList(ListNode head) {
        ListNode curr = head, prev = null, cache = null;
        while (curr != null) {
            cache = curr.next;
            if (prev != null) {
                curr.next = prev;
            } else {
                curr.next = null;
            }
            prev = curr;
            curr = cache;
        }
    }

    public static class ListNode {
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