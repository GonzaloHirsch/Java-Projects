package Median_Of_Two_Sorted_Arrays;

// ---------------------------------- SOLVED ----------------------------------

/**
 * Original problem: https://leetcode.com/problems/two-sum/
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
class Main {
    public static void main(String[] args){
        Solution sol = new Solution();
        int[] a = new int[]{1, 2};
        int[] b = new int[]{3, 4};
        System.out.println("Executing solution");
        System.out.println(sol.findMedianSortedArrays(a, b));
    }
}