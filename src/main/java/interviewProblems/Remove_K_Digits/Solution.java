package interviewProblems.Remove_K_Digits;

import java.util.Stack;

class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        char[] chars = num.toCharArray();

        // Iterate and add all chars
        for (char c : chars) {
            // Pop all numbers larger than the current one
            while (!stack.isEmpty() && k > 0 && stack.peek() > c) {
                stack.pop();
                k--;
            }
            // Add the number
            if (!stack.isEmpty() || c != '0') stack.push(c);
        }

        // Remove remaining
        while (!stack.isEmpty() && k-- > 0) stack.pop();

        // If no number, return the empty number
        if (stack.isEmpty()) return "0";

        // Build the result
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.append(stack.pop());
        sb.reverse();
        return sb.toString();
    }
}