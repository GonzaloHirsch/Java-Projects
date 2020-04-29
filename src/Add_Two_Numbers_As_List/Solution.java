package Add_Two_Numbers_As_List;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode A, ListNode B) {
        ListNode sol = new ListNode(0);
        ListNode SOL = sol;
        ListNode currA = A;
        ListNode currB = B;
        int carry = 0;
        int partial = 0;
        while(currA != null && currB != null){
            partial = currA.val + currB.val + carry;
            carry = partial / 10;
            partial = partial % 10;
            sol.val = partial;
            if (currA.next == null || currB.next == null){
                sol.next = null;
            } else {
                sol.next = new ListNode(0);
                sol = sol.next;
            }
            currA = currA.next;
            currB = currB.next;
        }
        if (currA == null && currB == null){
            if (carry > 0){
                sol.next = new ListNode(1);
            } else {
                sol.next = null;
            }
        } else {
            ListNode curr = currA == null ? currB : currA;
            while(curr != null){
                partial = curr.val + carry;
                carry = partial / 10;
                partial = partial % 10;
                sol.next = new ListNode(partial);
                sol = sol.next;
                curr = curr.next;
            }
            if (carry > 0){
                sol.next = new ListNode(1);
            } else {
                sol.next = null;
            }
        }
        return SOL;
    }

    public static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }
}

