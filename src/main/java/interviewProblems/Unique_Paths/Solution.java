package interviewProblems.Unique_Paths;

import java.util.Arrays;

class Solution {
    // m is rows, n is cols
    public int uniquePaths(int m, int n) {
        // Create and fill the sum array with 1s
        int[] sum = new int[m];
        sum[0] = 1;
        // Iterating for all rows
        for (int i = 0; i < n; i++) {
            // Iterate all the numbers
            for (int j = 1; j < m; j++) sum[j] += sum[j - 1];
        }
        return sum[sum.length - 1];
    }
}