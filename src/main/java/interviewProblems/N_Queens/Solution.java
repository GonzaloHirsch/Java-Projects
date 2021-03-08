package interviewProblems.N_Queens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    private List<int[]> solutions = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();

        // Some already known cases
        if (n == 1){
            List<String> sol = new ArrayList<>();
            sol.add("Q");
            res.add(sol);
        } else if (n > 3){
            int[] ns = new int[n];
            // Solve recursively
            this.solveRec(ns, 0);
            // Convert to required format
            for (int[] sol : this.solutions){
                res.add(this.transformSolution(sol));
            }
        }
        return res;
    }

    private List<String> transformSolution(int[] ns){
        List<String> sol = new ArrayList<>();
        for (int n : ns){
            String s = "";
            for (int i = 0; i < n; i++){
                s += ".";
            }
            s += "Q";
            for (int i = n + 1; i < ns.length; i++){
                s += ".";
            }
            sol.add(s);
        }
        return sol;
    }

    private void solveRec(int[] ns, int curr){
        if (curr == ns.length){
            this.solutions.add(Arrays.copyOf(ns, ns.length));
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
