package interviewProblems.Generate_Parentheses;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<String> result;
    private int n;

    public List<String> generateParenthesis(int n) {
        this.result = new ArrayList<>();
        this.n = n;
        this.generate("", 0, 0);
        return this.result;
    }

    public void generate(String curr, int open, int closed) {
        // Don't allow more closed than open ones
        if (open > this.n || closed > this.n) return;
        // If the limit is reached, return it
        if (open == closed && closed == this.n) {
            result.add(curr);
            return;
        }
        if (open > closed) this.generate(curr + ")", open, closed + 1);
        this.generate(curr + "(", open + 1, closed);
    }
}