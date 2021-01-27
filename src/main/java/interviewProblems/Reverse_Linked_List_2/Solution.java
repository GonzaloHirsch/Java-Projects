package interviewProblems.Reverse_Linked_List_2;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode A, int B, int C) {
        ListNode curr = A;
        int count = 1;
        while (curr != null){
            if (B == 1){
                A = reverse(A, C - B);
                return A;
            } else if (count == B - 1){
                curr.next = reverse(curr.next, C - B);
                return A;
            } else {
                curr = curr.next;
            }
            count++;
        }
        return A;
    }

    public ListNode reverse(ListNode a, int count){
        ListNode prev = null;
        ListNode curr = a;
        ListNode next = a.next;
        int i = 0;
        while(curr != null && i <= count){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            i++;
        }
        a.next = next;
        return prev;
    }

    public static class ListNode{
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }
}
