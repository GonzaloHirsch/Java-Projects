package interviewProblems.Letter_Combinations_Of_A_Phone_Number;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    private final char[][] LETTERS = new char[][] {
            new char[] {'a', 'b', 'c'},
            new char[] {'d', 'e', 'f'},
            new char[] {'g', 'h', 'i'},
            new char[] {'j', 'k', 'l'},
            new char[] {'m', 'n', 'o'},
            new char[] {'p', 'q', 'r', 's'},
            new char[] {'t', 'u', 'v'},
            new char[] {'w', 'x', 'y', 'z'}
    };
    private List<String> res;

    public List<String> letterCombinations(String digits) {
        this.res = new ArrayList<>();
        if (digits.isEmpty()) return res;
        this.combinationsRec(digits.toCharArray(), new char[digits.length()], 0);
        return this.res;
    }

    private void combinationsRec(char[] digits, char[] curr, int index) {
        if (index >= digits.length) this.res.add(new String(curr));
        else {
            for (char c : LETTERS[digits[index] - '2']) {
                curr[index] = c;
                this.combinationsRec(digits, curr, index + 1);
                curr[index] = 0;
            }
        }
    }
}