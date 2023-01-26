package interviewProblems.Advent_Of_Code_2022.Day_8.Part_1;

public class Solution {
    public int calculateHidden(int[][] mat) {
        int hidden = 0;
        // Compute max matrices
        int[][] maxL = this.computeMaxL(mat), maxR = this.computeMaxR(mat), maxT = this.computeMaxT(mat), maxB = this.computeMaxB(mat);
        // Iterate and check for hidden ones
        for (int i = 1; i < mat.length - 1; i++) {
            for (int j = 1, num = 0; j < mat[0].length - 1; j++) {
                num = mat[i][j];
                if (num <= maxL[i][j - 1] && num <= maxR[i][j + 1] && num <= maxT[i - 1][j] && num <= maxB[i + 1][j]) hidden++;
            }
        }

        return (mat.length * mat[0].length) - hidden;
    }

    private int[][] computeMaxL(int[][] mat) {
        int[][] res = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (isInBounds(i, j, mat.length - 1, mat[0].length - 1)) res[i][j] = mat[i][j];
                else res[i][j] = Math.max(res[i][j - 1], mat[i][j]);
            }
        }
        return res;
    }

    private int[][] computeMaxR(int[][] mat) {
        int[][] res = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = mat[0].length - 1; j >= 0; j--) {
                if (isInBounds(i, j, mat.length - 1, mat[0].length - 1)) res[i][j] = mat[i][j];
                else res[i][j] = Math.max(res[i][j + 1], mat[i][j]);
            }
        }
        return res;
    }

    private int[][] computeMaxT(int[][] mat) {
        int[][] res = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (isInBounds(i, j, mat.length - 1, mat[0].length - 1)) res[i][j] = mat[i][j];
                else res[i][j] = Math.max(res[i - 1][j], mat[i][j]);
            }
        }
        return res;
    }

    private int[][] computeMaxB(int[][] mat) {
        int[][] res = new int[mat.length][mat[0].length];
        for (int i = mat.length - 1; i >= 0; i--) {
            for (int j = 0; j < mat[0].length; j++) {
                if (isInBounds(i, j, mat.length - 1, mat[0].length - 1)) res[i][j] = mat[i][j];
                else res[i][j] = Math.max(res[i + 1][j], mat[i][j]);
            }
        }
        return res;
    }

    private boolean isInBounds(int i, int j, int limI, int limJ) {
        return i == 0 || j == 0 || i == limI || j == limJ;
    }
}