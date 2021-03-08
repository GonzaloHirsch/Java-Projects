package interviewProblems.Reverse_Nodes_In_K_Groups;

// ---------------------------------- SOLVED ----------------------------------
// --------------------------- FACEBOOK / March 2021 --------------------------

import interviewProblems.Two_Sum.AlternativeSolution;
import interviewProblems.Two_Sum.Solution;

/**
 * Original problem: https://leetcode.com/problems/reverse-nodes-in-k-group/
 *
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
 *
 * Follow up:
 *
 * Could you solve the problem in O(1) extra memory space?
 * You may not alter the values in the list's nodes, only nodes itself may be changed.
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [2,1,4,3,5]
 * Example 2:
 *
 *
 * Input: head = [1,2,3,4,5], k = 3
 * Output: [3,2,1,4,5]
 * Example 3:
 *
 * Input: head = [1,2,3,4,5], k = 1
 * Output: [1,2,3,4,5]
 * Example 4:
 *
 * Input: head = [1], k = 1
 * Output: [1]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range sz.
 * 1 <= sz <= 5000
 * 0 <= Node.val <= 1000
 * 1 <= k <= sz
 */
class Main {
    public static void main(String[] args){
        interviewProblems.Two_Sum.Solution sol = new Solution();
        AlternativeSolution solution = new AlternativeSolution();
        int[] nums = new int[]{230,863,916,585,981,404,316,785,88,12,70,435,384,778,887,755,740,337,86,92,325,422,815,650,920,125,277,336,221,847,168,23,677,61,400,136,874,363,394,199,863,997,794,587,124,321,212,957,764,173,314,422,927,783,930,282,306,506,44,926,691,568,68,730,933,737,531,180,414,751,28,546,60,371,493,370,527,387,43,541,13,457,328,227,652,365,430,803,59,858,538,427,583,368,375,173,809,896,370,789};
        int target = 542;
        System.out.println("Executing solution");
        System.out.println(solution.twoSum(nums, target));
    }
}