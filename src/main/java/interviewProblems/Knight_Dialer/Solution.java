package interviewProblems.Knight_Dialer;

import java.util.*;

class Solution {
    private static int MOD = (int)Math.pow(10, 9) + 7;
    private static int[][] STEPS = new int[][]{
            new int[]{4, 6, -1},
            new int[]{8, 6, -1},
            new int[]{7, 9, -1},
            new int[]{4, 8, -1},
            new int[]{3, 9, 0},
            new int[]{-1, -1, -1},
            new int[]{1, 7, 0},
            new int[]{2, 6, -1},
            new int[]{1, 3, -1},
            new int[]{2, 4, -1},
    };
    public int knightDialer(int n) {
        int[][] numbersEndingIn = new int[2][10];

        // Set initial case which is with n = 1
        for (int i = 0; i < 10; i++) numbersEndingIn[0][i] = 1;

        // Each new row is based on the previous one
        for (int i = 1; i < n; i++) {
            // Build the new row
            for (int j = 0; j < 10; j++) {
                int tot = 0;
                for (int s : STEPS[j]) tot = ((tot % MOD) + (s >= 0 ? (numbersEndingIn[0][s] % MOD) : 0) % MOD);
                numbersEndingIn[1][j] = tot;
            }
            // Move the row to the previous one
            for (int j = 0, tot = 0; j < 10; j++) numbersEndingIn[0][j] = numbersEndingIn[1][j];
        }

        // Sum all at the end
        int res = 0;
        for (int num : numbersEndingIn[0]) res = ((res % MOD) + (num % MOD)) % MOD;
        return res;
    }
}