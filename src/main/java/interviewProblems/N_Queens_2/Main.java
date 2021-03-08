package interviewProblems.N_Queens_2;

// ---------------------------------- SOLVED ----------------------------------
// --------------------------- FACEBOOK / March 2021 --------------------------

import interviewProblems.Two_Sum.AlternativeSolution;
import interviewProblems.Two_Sum.Solution;

/**
 * Original problem: https://leetcode.com/problems/n-queens-ii/
 *
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
 *
 * Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 *
 * Example 1:
 *
 * Input: n = 4
 * Output: 2
 * Explanation: There are two distinct solutions to the 4-queens puzzle as shown.
 * Example 2:
 *
 * Input: n = 1
 * Output: 1
 *
 * Constraints:
 *
 * 1 <= n <= 9
 */
class Main {
    public static void main(String[] args){
        Solution sol = new Solution();
        AlternativeSolution solution = new AlternativeSolution();
        int[] nums = new int[]{230,863,916,585,981,404,316,785,88,12,70,435,384,778,887,755,740,337,86,92,325,422,815,650,920,125,277,336,221,847,168,23,677,61,400,136,874,363,394,199,863,997,794,587,124,321,212,957,764,173,314,422,927,783,930,282,306,506,44,926,691,568,68,730,933,737,531,180,414,751,28,546,60,371,493,370,527,387,43,541,13,457,328,227,652,365,430,803,59,858,538,427,583,368,375,173,809,896,370,789};
        int target = 542;
        System.out.println("Executing solution");
        System.out.println(solution.twoSum(nums, target));
    }
}