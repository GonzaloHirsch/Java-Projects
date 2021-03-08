package interviewProblems.N_Queens_2;

import java.util.Comparator;

class Solution {
    private int solutions = 0;

    private static final Comparator<int[]> COMP = new Comparator<int[]>() {
        @Override
        public int compare(int[] a, int[] b) {
            return Integer.compare(a[H], b[H]);
        }
    }

    public int totalNQueens(int n) {
        // Some already known cases
        if (n == 1){
            return 1;
        } else if (n > 3){
            int[] ns = new int[n];
            this.solveRec(ns, 0);
            return this.solutions;
        }
        return 0;
    }

    private void solveRec(int[] ns, int curr){
        if (curr == ns.length){
            this.solutions++;
        } else {
            // Get all possible positions
            int[] possiblePositions = new int[ns.length];
            int diff = 0;
            for (int i = 0; i < possiblePositions.length; i++){
                for (int j = curr - 1; j >= 0; j--){
                    // Mark verticals
                    possiblePositions[ns[j]] = 1;
                    // Calculate difference
                    diff = curr - j;
                    // Mark diagonals
                    if (ns[j] + diff < ns.length){
                        possiblePositions[ns[j] + diff] = 1;
                    }
                    if (ns[j] - diff >= 0){
                        possiblePositions[ns[j] - diff] = 1;
                    }
                }
            }

            // Try to do it in other positions
            for (int i = 0; i < possiblePositions.length; i++){
                // Possible position
                if (possiblePositions[i] == 0){
                    ns[curr] = i;
                    this.solveRec(ns, curr + 1);
                    ns[curr] = 0;
                }
            }
        }
    }
}
