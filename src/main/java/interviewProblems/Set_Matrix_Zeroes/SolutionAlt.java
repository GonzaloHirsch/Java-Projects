package interviewProblems.Set_Matrix_Zeroes;


class SolutionAlt {
    public void setZeroes(int[][] matrix) {
        boolean isCol = false;

        // Iterate once to mark the matrix
        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row][0] == 0) isCol = true;
            for (int col = 1; col < matrix[0].length; col++) {
                if (matrix[row][col] == 0) {
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }

        // Iterate again to update given the row/col
        for (int row = 1; row < matrix.length; row++) {
            for (int col = 1; col < matrix[0].length; col++) {
                if (matrix[0][col] == 0 || matrix[row][0] == 0) {
                    matrix[row][col] = 0;
                }
            }
        }

        // Mark the first col
        if (matrix[0][0] == 0) for (int col = 0; col < matrix[0].length; col++) matrix[0][col] = 0;

        if (isCol) for (int row = 0; row < matrix.length; row++) matrix[row][0] = 0;
    }
}