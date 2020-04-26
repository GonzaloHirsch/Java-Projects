package Largest_Distance_Between_Nodes_Of_A_Tree;

// ---------------------------------- SOLVED ----------------------------------
// --------------------------- FACEBOOK / April 2020 --------------------------
// ------------------- SolutionAlternative -> Most Optimal --------------------
import java.util.ArrayList;

/**
 * Original problem: https://www.interviewbit.com/problems/largest-distance-between-nodes-of-a-tree/
 *
 * Find largest distance
 * Given an arbitrary unweighted rooted tree which consists of N (2 <= N <= 40000) nodes. The goal of the problem is to find largest distance between two nodes in a tree. Distance between two nodes is a number of edges on a path between the nodes (there will be a unique path between any pair of nodes since it is a tree). The nodes will be numbered 0 through N - 1.
 *
 * The tree is given as an array P, there is an edge between nodes P[i] and i (0 <= i < N). Exactly one of the i’s will have P[i] equal to -1, it will be root node.
 *
 *  Example:
 * If given P is [-1, 0, 0, 0, 3], then node 0 is the root and the whole tree looks like this:
 *           0
 *        /  |  \
 *       1   2   3
 *                \
 *                 4
 *  One of the longest path is 1 -> 0 -> 3 -> 4 and its length is 3, thus the answer is 3. Note that there are other paths with maximal distance.
 */
class Main {
    public static void main(String[] args){
        Solution sol = new Solution();
        int[] b = new int[]{ -1, 0, 1, 1, 2, 0, 5, 0, 3, 0, 0, 2, 3, 1, 12, 14, 0, 5, 9, 6, 16, 0, 13, 4, 17, 2, 1, 22, 14, 20, 10, 17, 0, 32, 15, 34, 10, 19, 3, 22, 29, 2, 36, 16, 15, 37, 38, 27, 31, 12, 24, 29, 17, 29, 32, 45, 40, 15, 35, 13, 25, 57, 20, 4, 44, 41, 52, 9, 53, 57, 18, 5, 44, 29, 30, 9, 29, 30, 8, 57, 8, 59, 59, 64, 37, 6, 54, 32, 40, 26, 15, 87, 49, 90, 6, 81, 73, 10, 8, 16};
        ArrayList<Integer> a = new ArrayList<>();
        for (int i : b){
            a.add(i);
        }
        sol.solve(a);
    }
}