package Reverse_Linked_List_2;

// ---------------------------------- SOLVED ----------------------------------
// --------------------------- FACEBOOK / April 2020 --------------------------
/**
 * Original problem: https://www.interviewbit.com/problems/reverse-link-list-ii/
 *
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 *
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 *
 * return 1->4->3->2->5->NULL.
 *
 *  Note:
 * Given m, n satisfy the following condition:
 * 1 ≤ m ≤ n ≤ length of list. Note 2:
 * Usually the version often seen in the interviews is reversing the whole linked list which is obviously an easier version of this question.
 */
class Main {
    public static void main(String[] args){
        Solution sol = new Solution();
        Solution.ListNode a = new Solution.ListNode(1);
        Solution.ListNode b = new Solution.ListNode(2);
        Solution.ListNode c = new Solution.ListNode(3);
//        Solution.ListNode d = new Solution.ListNode(4);
//        Solution.ListNode e = new Solution.ListNode(5);
        a.next = b;
        b.next = c;
//        c.next = d;
//        d.next = e;
        sol.reverseBetween(a, 1, 2);
    }
}