package interviewProblems.All_Unique_Permutations;

// ---------------------------------- SOLVED ----------------------------------
// --------------------------- FACEBOOK / April 2020 --------------------------
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Original problem: https://www.interviewbit.com/problems/all-unique-permutations/
 *
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 *
 * Example :
 * [1,1,2] have the following unique permutations:
 *
 * [1,1,2]
 * [1,2,1]
 * [2,1,1]
 *  NOTE : No 2 entries in the permutation sequence should be the same.
 *  Warning : DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS. Example : next_permutations in C++ / itertools.permutations in python.
 * If you do, we will disqualify your submission retroactively and give you penalty points.
 */
class Main {
    public static void main(String[] args){
        Solution sol = new Solution();
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        a.add(6);
        a.add(7);
        a.add(8);
        sol.permute(a);
    }
}