package interviewProblems.Trapping_Rain_Water_2;

// ---------------------------------- SOLVED ----------------------------------
// --------------------------- TOPTAL / August 2020 --------------------------
/**
 * Original problem: https://leetcode.com/problems/trapping-rain-water-ii/
 *
 * Difficulty: Hard
 *
 * Given an m x n matrix of positive integers representing the height of each unit cell in a 2D elevation map, compute the volume of water it is able to trap after raining.
 *
 * Example:
 *
 * Given the following 3x6 height map:
 * [
 *   [1,4,3,1,3,2],
 *   [3,2,1,3,2,4],
 *   [2,3,3,2,3,1]
 * ]
 *
 * Return 4.
 *
 * The above image represents the elevation map [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]] before the rain.
 *
 * After the rain, water is trapped between the blocks. The total volume of water trapped is 4.
 *
 * Constraints:
 *
 * 1 <= m, n <= 110
 * 0 <= heightMap[i][j] <= 20000
 */
class Main {
    public static void main(String[] args){
        Solution sol = new Solution();
        int[][] m = new int[6][6];
        m[0] = new int[]{4,4,6,4,5,6};
        m[1] = new int[]{3,2,3,4,5,3};
        m[2] = new int[]{5,2,3,4,5,2};
        m[3] = new int[]{1,6,3,4,5,1};
        m[4] = new int[]{3,2,3,4,5,1};
        m[5] = new int[]{4,5,6,4,5,6};
        int[][] m2 = new int[6][6];
        m2[0] = new int[]{1,6,6,6,6,1};
        m2[1] = new int[]{6,1,3,2,1,6};
        m2[2] = new int[]{6,4,1,1,1,6};
        m2[3] = new int[]{6,5,1,1,2,6};
        m2[4] = new int[]{6,1,4,3,1,6};
        m2[5] = new int[]{1,6,6,6,6,1};
        int[][] m3 = new int[6][6];
        m3[0] = new int[]{1,1,6,1,6,1};
        m3[1] = new int[]{6,1,1,6,1,6};
        m3[2] = new int[]{1,4,1,4,1,6};
        m3[3] = new int[]{1,5,1,1,1,6};
        m3[4] = new int[]{1,2,1,3,1,6};
        m3[5] = new int[]{1,6,6,1,6,1};
        System.out.println("THE SOLUTION IS: " + sol.trapRainWater(m3));
    }
}