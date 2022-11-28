package interviewProblems.Set_Matrix_Zeroes;


import java.util.*;

class Solution {
    public void setZeroes(int[][] matrix) {
        int[] row = new int[matrix.length], col = new int[matrix[0].length];

        // Iterate once to find all the 0s
        for (int i = 0; i < row.length; i++) {
            for (int j = 0; j < col.length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        // Iterate second time to set everything
        for (int i = 0; i < row.length; i++) {
            for (int j = 0; j < col.length; j++) {
                if (row[i] == 1 || col[j] == 1) matrix[i][j] = 0;
            }
        }
    }
}
