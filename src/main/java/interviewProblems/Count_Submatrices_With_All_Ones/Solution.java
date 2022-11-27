package interviewProblems.Count_Submatrices_With_All_Ones;

import java.util.Arrays;


class Solution {
    public int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length, res = 0;
        int[] height = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Heights takes care of counting vertical height too
                height[j] = mat[i][j] == 0 ? 0 : height[j] + 1;
                for (int k = j, min = height[j]; k >= 0 && min > 0; k--) {
                    min = Math.min(min, height[k]);
                    res += min;
                }
            }
        }
        return res;
    }
}