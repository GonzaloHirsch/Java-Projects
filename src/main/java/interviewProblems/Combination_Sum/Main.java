package interviewProblems.Combination_Sum;

// ---------------------------------- SOLVED ----------------------------------
// --------------------------- FACEBOOK / April 2020 --------------------------
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Original problem: https://www.interviewbit.com/problems/combination-sum/
 *
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 *
 * The same repeated number may be chosen from C unlimited number of times.
 *
 *  Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The combinations themselves must be sorted in ascending order.
 * CombinationA > CombinationB iff (a1 > b1) OR (a1 = b1 AND a2 > b2) OR … (a1 = b1 AND a2 = b2 AND … ai = bi AND ai+1 > bi+1)
 * The solution set must not contain duplicate combinations.
 * Example,
 * Given candidate set 2,3,6,7 and target 7,
 * A solution set is:
 *
 * [2, 2, 3]
 * [7]
 */
class Main {
    public static void main(String[] args){
        Solution sol = new Solution();
        Integer[] a = new Integer[]{8, 10, 6, 11, 1, 16, 8};
        ArrayList b = new ArrayList<Integer>(Arrays.asList(a));
        int sum = 28;
        sol.combinationSum(b, sum);
    }
}