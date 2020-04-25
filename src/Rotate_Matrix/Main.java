package Rotate_Matrix;

// ---------------------------------- SOLVED ----------------------------------

import java.util.ArrayList;

/**
 * Original problem: https://www.interviewbit.com/problems/rotate-matrix/
 *
 * You are given an n x n 2D matrix representing an image.
 *
 * Rotate the image by 90 degrees (clockwise).
 *
 * You need to do this in place.
 *
 * Note that if you end up using an additional array, you will only receive partial score.
 *
 * Example:
 *
 * If the array is
 *
 * [
 *     [1, 2],
 *     [3, 4]
 * ]
 * Then the rotated array becomes:
 *
 * [
 *     [3, 1],
 *     [4, 2]
 * ]
 */
class Main {
    public static void main(String[] args){
        Solution sol = new Solution();
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