package interviewProblems.Unique_Paths_In_A_Grid;

// ---------------------------------- SOLVED ----------------------------------
// --------------------------- FACEBOOK / April 2020 --------------------------

import java.util.ArrayList;

/**
 * Original problem: https://www.interviewbit.com/problems/unique-paths-in-a-grid/
 *
 * Given a grid of size m * n, lets assume you are starting at (1,1) and your goal is to reach (m,n). At any instance, if you are on (x,y), you can either go to (x, y + 1) or (x + 1, y).
 *
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 *
 * Example :
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 *
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * The total number of unique paths is 2.
 *
 * Note: m and n will be at most 100.
 */
class Main {
    public static void main(String[] args){
        Solution sol = new Solution();
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        ArrayList<Integer> c = new ArrayList<>();
        ArrayList<Integer> d = new ArrayList<>();
        b.add(0);
        b.add(0);
        b.add(0);
        c.add(0);
        c.add(0);
        c.add(0);
        d.add(0);
        d.add(0);
        d.add(0);
        a.add(b);
        a.add(c);
        a.add(d);
        sol.uniquePathsWithObstacles(a);
    }
}