package interviewProblems.Add_Two_Numbers;

import java.util.List;

// ---------------------------------- SOLVED ----------------------------------
// --------------------------- FACEBOOK / April 2020 --------------------------
// ---------------------- BLOCKCHAIN.COM / December 2022 ----------------------
/**
 * Original problem: https://leetcode.com/problems/add-two-numbers/
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
class Main {
    public static void main(String[] args){
        Solution sol = new Solution();
        Solution.ListNode l1 = new Solution.ListNode(5);
        Solution.ListNode l2 = new Solution.ListNode(5);
        System.out.println("Executing solution");
        System.out.println(sol.addTwoNumbers(l1, l2));
    }
}