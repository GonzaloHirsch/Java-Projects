package interviewProblems.Largest_Rectangle_In_Histogram;

// ---------------------------------- SOLVED ----------------------------------
// --------------------------- FACEBOOK / May 2020 --------------------------

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Original problem: https://www.interviewbit.com/problems/largest-rectangle-in-histogram/
 *
 * Given an array of integers A of size N. A represents a histogram i.e A[i] denotes height of
 * the ith histogram’s bar. Width of each bar is 1.
 *
 * Largest Rectangle in Histogram: Example 1
 *
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 *
 * Largest Rectangle in Histogram: Example 2
 *
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 *
 * Find the area of largest rectangle in the histogram.
 *
 * Input Format
 *
 * The only argument given is the integer array A.
 * Output Format
 *
 * Return the area of largest rectangle in the histogram.
 * For Example
 *
 * Input 1:
 *     A = [2, 1, 5, 6, 2, 3]
 * Output 1:
 *     10
 *     Explanation 1:
 *         The largest rectangle is shown in the shaded area, which has area = 10 unit.
 */
class Main {
    public static void main(String[] args){
        Solution sol = new Solution();
        sol.largestRectangleArea(new ArrayList<>(Arrays.asList(1)));
    }
}