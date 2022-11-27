package interviewProblems.Range_Sum_Query_2D_Immutable;

class NumMatrix {
    private int[][] sums;

    public NumMatrix(int[][] matrix) {
        this.sums = new int[matrix.length][matrix[0].length];
        // Precompute
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0, sum = 0; col < matrix[0].length; col++) {
                sum += matrix[row][col];
                this.sums[row][col] = sum;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int tot = 0;
        for (int row = row1; row <= row2; row++) {
            tot += (this.sums[row][col2] - (col1 > 0 ? this.sums[row][col1 - 1] : 0));
        }
        return tot;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */

