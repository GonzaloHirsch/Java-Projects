package interviewProblems.Tallest_Billboard;

// ---------------------------------- SOLVED ----------------------------------
// --------------------------- FACEBOOK / March 2021 --------------------------

import interviewProblems.Two_Sum.AlternativeSolution;
import interviewProblems.Two_Sum.Solution;

/**
 * Original problem: https://leetcode.com/problems/tallest-billboard/
 *
 * You are installing a billboard and want it to have the largest height. The billboard will have two steel supports, one on each side. Each steel support must be an equal height.
 *
 * You are given a collection of rods that can be welded together. For example, if you have rods of lengths 1, 2, and 3, you can weld them together to make a support of length 6.
 *
 * Return the largest possible height of your billboard installation. If you cannot support the billboard, return 0.
 *
 * Example 1:
 *
 * Input: rods = [1,2,3,6]
 * Output: 6
 * Explanation: We have two disjoint subsets {1,2,3} and {6}, which have the same sum = 6.
 * Example 2:
 *
 * Input: rods = [1,2,3,4,5,6]
 * Output: 10
 * Explanation: We have two disjoint subsets {2,3,5} and {4,6}, which have the same sum = 10.
 * Example 3:
 *
 * Input: rods = [1,2]
 * Output: 0
 * Explanation: The billboard cannot be supported, so we return 0.
 *
 * Constraints:
 *
 * 1 <= rods.length <= 20
 * 1 <= rods[i] <= 1000
 * sum(rods[i]) <= 5000
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