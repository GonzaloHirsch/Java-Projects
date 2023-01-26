package interviewProblems.Advent_Of_Code_2022.Day_8.Part_2;

public class Solution {
    public int calculateHidden(int[][] mat) {
        int maxScore = 0;
        // Compute max matrices
        //int[][] maxL = this.computeMaxL(mat), maxR = this.computeMaxR(mat), maxT = this.computeMaxT(mat), maxB = this.computeMaxB(mat);
        // Iterate and check for hidden ones
        for (int i = 1; i < mat.length - 1; i++) {
            for (int j = 1; j < mat[0].length - 1; j++) {
                maxScore = Math.max(maxScore, this.computeScore(mat, i, j));
            }
        }

        return maxScore;
    }

    private int computeScore(int[][] mat, int i, int j) {
        int t = 0, b = 0, l = 0, r = 0;
        for (int n = i + 1; n < mat.length; n++) {
            if (mat[i][j] <= mat[n][j]) {
                b = (n - i);
                break;
            }
        }
        b = b > 0 ? b : mat.length - i - 1;
        for (int n = i - 1; n >= 0; n--) {
            if (mat[i][j] <= mat[n][j]) {
                t = (i - n);
                break;
            }
        }
        t = t > 0 ? t : i;
        for (int n = j + 1; n < mat[0].length; n++) {
            if (mat[i][j] <= mat[i][n]) {
                r = (n - j);
                break;
            }
        }
        r = r > 0 ? r : mat[0].length - j - 1;
        for (int n = j - 1; n >= 0; n--) {
            if (mat[i][j] <= mat[i][n]) {
                l = (j - n);
                break;
            }
        }
        l = l > 0 ? l : j;
        return t * b * l * r;
    }
}