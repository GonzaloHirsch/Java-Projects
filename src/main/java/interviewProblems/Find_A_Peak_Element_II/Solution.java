package interviewProblems.Find_A_Peak_Element_II;

import java.util.*;
class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int low = 0, high = mat[0].length, mid = 0, colMaxI = 0, colMax = 0, m = mat.length, n = mat[0].length;
        // Use binary search to go looking for global maximums
        while (low < high) {
            mid = (int)(low + high) / 2;
            // Look for maximum in the column
            for (int i = 0; i < mat.length; i++) {
                if (mat[i][mid] > colMax) {
                    colMax = mat[i][mid];
                    colMaxI = i;
                }
            }
            // Check with neighbours, if not within range, assume the current max is larger
            if (mid + 1 < n && mat[colMaxI][mid + 1] > colMax) {
                low = mid;
            } else if (mid - 1 >= 0 && mat[colMaxI][mid - 1] > colMax) {
                high = mid;
            } else {
                // Found peak
                return new int[]{colMaxI, mid};
            }
        }
        return new int[]{colMaxI, mid};
    }
}