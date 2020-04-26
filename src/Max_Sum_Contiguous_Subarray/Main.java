package Max_Sum_Contiguous_Subarray;

// ---------------------------------- SOLVED ----------------------------------
// --------------------------- FACEBOOK / April 2020 --------------------------
import Rotate_Matrix.Solution;

import java.util.ArrayList;

/**
 * Original problem: https://www.interviewbit.com/problems/max-sum-contiguous-subarray/
 *
 * Find the contiguous subarray within an array, A of length N which has the largest sum.
 *
 * Input Format:
 *
 * The first and the only argument contains an integer array, A.
 * Output Format:
 *
 * Return an integer representing the maximum possible sum of the contiguous subarray.
 * Constraints:
 *
 * 1 <= N <= 1e6
 * -1000 <= A[i] <= 1000
 * For example:
 *
 * Input 1:
 *     A = [1, 2, 3, 4, -10]
 *
 * Output 1:
 *     10
 *
 * Explanation 1:
 *     The subarray [1, 2, 3, 4] has the maximum possible sum of 10.
 *
 * Input 2:
 *     A = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
 *
 * Output 2:
 *     6
 *
 * Explanation 2:
 *     The subarray [4,-1,2,1] has the maximum possible sum of 6.
 */
class Main {
    public static void main(String[] args){
        Rotate_Matrix.Solution sol = new Solution();
        ArrayList<Integer> a1 = new ArrayList<>();
        a1.add(1);
        a1.add(2);
        ArrayList<Integer> a2 = new ArrayList<>();
        a2.add(3);
        a2.add(4);
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        a.add(a1);
        a.add(a2);
        System.out.println("Executing solution");
        sol.rotate(a);
    }
}