package interviewProblems.Student_Attendance_Record_II;

class Solution {
    private final int MOD = (int)1e9 + 7;

    public int checkRecord(int n) {
        if (n == 1) return 3;
        if (n == 2) return 8;
        // Each array contains the number of strings ending in each letter of size N
        int[] A = new int[n], L = new int[n], P = new int[n];
        // Create the initial values
        A[0] = 1;   // A
        A[1] = 2;   // LA, PA
        A[2] = 4;   // PPA, PLA, LPA, LLA
        L[0] = 1;   // L
        L[1] = 3;   // AL, PL, LL
        L[2] = 7;    // LAL, PAL, PPL, APL, LPL, PLL, ALL
        P[0] = 1;   // P
        P[1] = 3;   // PP, AP, LP
        P[2] = 8;    // PPP, APP, LPP, ALP, PLP, LLP, LAP, PA
        // Iterate
        for (int i = 3; i < n; i++) {
            // P is adding a P to each of the strings of the others
            P[i] = (((P[i - 1] + A[i - 1]) % MOD) + L[i - 1]) % MOD;
            // L is adding an L to the P and A, but adding 2 Ls to the previous P and A
            L[i] = (((P[i - 1] + A[i - 1]) % MOD) + ((P[i - 2] + A[i - 2]) % MOD)) % MOD;
            A[i] = (((A[i - 1] + A[i - 2]) % MOD) + A[i - 3]) % MOD;
        }
        return (((P[n - 1] + A[n - 1]) % MOD) + L[n - 1]) % MOD;
    }
}