package interviewProblems.Longest_Valid_Parenthesis;

import java.util.*;

public class Solution {
    public int longestValidParentheses(String s) {
        int left = -1, max = 0;
        Deque<Integer> d = new ArrayDeque<Integer>();

        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '(') d.push(i);
            else {
                if (d.isEmpty()) left = i;
                else {
                    d.pop();
                    if (d.isEmpty()) max = Math.max(max, i - left);
                    else max = Math.max(max, i - d.peek());
                }
            }
        }

        return max;
    }
}