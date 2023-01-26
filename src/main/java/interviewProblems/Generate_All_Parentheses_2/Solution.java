package interviewProblems.Generate_All_Parentheses_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Solution {
    public ArrayList<String> generateParenthesis(int A) {
        HashSet<String> sol = new HashSet<>();
        char[] arr = new char[2 * A];
        this.generateParenthesisRecursive(A, 0, 0, sol, arr);
        ArrayList<String> sortedSol = new ArrayList<>(sol);
        Collections.sort(sortedSol);
        return sortedSol;
    }

    private void generateParenthesisRecursive(int A, int left, int right, HashSet<String> l, char[] curr){
        int pos = left + right;
        if (pos == 2 * A){
            String s = new String(curr);
            l.add(s);
        }
        if (left < A){
            curr[pos] = '(';
            this.generateParenthesisRecursive(A, left + 1, right, l, curr);
        }
        if (right < left){
            curr[pos] = ')';
            this.generateParenthesisRecursive(A, left, right + 1, l, curr);
        }
    }
}
