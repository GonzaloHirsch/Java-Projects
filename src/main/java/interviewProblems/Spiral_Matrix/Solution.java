package interviewProblems.Spiral_Matrix;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private static final int[][] DIRECTIONS = new int[][] {
            new int[]{0,1}, new int[]{1,0}, new int[]{0,-1}, new int[]{-1,0}
    };

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int n = matrix.length * matrix[0].length, x = -1, y = 0, d = 0;
        while (list.size() < n) {
            if (DIRECTIONS[d][0] + y < 0 || DIRECTIONS[d][0] + y >= matrix.length ||
                    DIRECTIONS[d][1] + x < 0 || DIRECTIONS[d][1] + x >= matrix[0].length ||
                    matrix[DIRECTIONS[d][0] + y][DIRECTIONS[d][1] + x] == Integer.MAX_VALUE) d = (d + 1) % DIRECTIONS.length;
            else {
                y += DIRECTIONS[d][0];
                x += DIRECTIONS[d][1];
                list.add(matrix[y][x]);
                matrix[y][x] = Integer.MAX_VALUE;
            }
        }
        return list;
    }
}