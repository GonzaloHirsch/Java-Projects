package interviewProblems.Add_Two_Numbers;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sol = new ListNode(0);
        ListNode actual = sol;
        int carry = 0;
        while (l1 != null && l2 != null){
            if (l1.val + l2.val + carry >= 10){
                actual.val = l1.val + l2.val + carry - 10;
            } else {
                actual.val = l1.val + l2.val + carry;
            }
            carry = l1.val + l2.val + carry >= 10 ? 1 : 0;
            l2 = l2.next;
            l1 = l1.next;
            if (l1 == null && l2 == null){
                if (carry == 1){
                    actual.next = new ListNode(1);
                } else {
                    actual.next = null;
                }
            }
            else {actual.next = new ListNode(0);}
            actual = actual.next;
        }
        while (l1 != null){
            if (l1.val + carry >= 10){
                actual.val = l1.val + carry - 10;
            } else {
                actual.val = l1.val + carry;
            }
            carry = l1.val + carry >= 10 ? 1 : 0;
            l1 = l1.next;
            if (l1 == null){
                if (carry == 1){
                    actual.next = new ListNode(1);
                } else {
                    actual.next = null;
                }
            }
            else {actual.next = new ListNode(0);}
            actual = actual.next;
        }
        while (l2 != null){
            if (l2.val + carry >= 10){
                actual.val = l2.val + carry - 10;
            } else {
                actual.val = l2.val + carry;
            }
            carry = l2.val + carry >= 10 ? 1 : 0;
            l2 = l2.next;
            if (l2 == null){
                if (carry == 1){
                    actual.next = new ListNode(1);
                } else {
                    actual.next = null;
                }
            }
            else {actual.next = new ListNode(0);}
            actual = actual.next;
        }
        return sol;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}