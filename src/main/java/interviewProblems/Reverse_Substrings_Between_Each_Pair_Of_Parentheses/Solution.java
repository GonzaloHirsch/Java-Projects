package interviewProblems.Reverse_Substrings_Between_Each_Pair_Of_Parentheses;

import java.util.Stack;

class Solution {
    public String reverseParentheses(String s) {
        Stack<String> stack = new Stack<>();
        char[] chars = s.toCharArray();

        // Iterate all characters
        for (char c : chars) {
            switch (c) {
                // When finding a closing bracket, pop, reverse and reinsert
                case ')':
                    String curr = stack.pop();
                    StringBuilder sb = new StringBuilder();
                    while (!curr.equals("(")) {
                        sb.insert(0, curr);
                        curr = stack.pop();
                    }
                    // Reverse the string and add back
                    sb.reverse();
                    stack.push(sb.toString());
                    break;
                // If opening bracket or character, just push to stack
                default: stack.push(String.valueOf(c));
            }
        }

        // Once we finished, we need to build the response
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) res.insert(0, stack.pop());
        return res.toString();
    }
}