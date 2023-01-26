package interviewProblems.Basic_Calculator_II;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    // PEMDAS, Potentiation, Exponent, Multiplication, Division, Addition, Substraction
    public int calculate(String s) {
        char[] chars = s.toCharArray();
        Deque<String> deque = new LinkedList<>();
        for (int i = 0; i < chars.length; i++) {
            // Ignore spaces
            if (chars[i] == ' ') continue;
            // Empty stack, just push. Should be a number
            if (deque.isEmpty()) {
                deque.addLast(String.valueOf(chars[i]));
                continue;
            }
            // Check if the top element is an operand
            // Mult / Div are given priority
            if (isMult(deque.peekLast())) {
                String operand = deque.removeLast();
                int right = chars[i] - '0', left = Integer.parseInt(deque.removeLast()), j = i + 1;
                // Look until the right number is complete
                for (; j < chars.length && chars[j] >= '0' && chars[j] <= '9'; j++) right = right * 10 + (chars[j] - '0');
                i = j - 1;
                deque.addLast(String.valueOf(operate(left, right, operand)));
            }
            // Current is operand, must be number the next one
            else if (isAdd(deque.peekLast())) deque.addLast(String.valueOf(chars[i]));
                // Add / Sub are left for the end of the processing
                // It's a number
            else {
                // Char is number, just add it
                if (isNum(chars[i])) deque.addLast(deque.removeLast() + chars[i]);
                    // It's an operand, just push it
                else deque.addLast(String.valueOf(chars[i]));
            }
        }

        // Iterate the stack while the size is greater than 1 to finish off the add/sub
        while (deque.size() > 1) {
            int left = Integer.parseInt(deque.pollFirst());
            String operand = deque.pollFirst();
            int right = Integer.parseInt(deque.pollFirst());
            deque.addFirst(String.valueOf(operate(left, right, operand)));
        }

        return Integer.parseInt(deque.removeFirst());
    }

    public boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }

    public boolean isMult(String str) {
        return str.equals("*") || str.equals("/");
    }

    public boolean isAdd(String str) {
        return str.equals("+") || str.equals("-");
    }

    public int operate(int a, int b, String operand) {
        switch (operand) {
            case "+": return a + b;
            case "/": return a / b;
            case "*": return a * b;
            case "-": return a - b;
        }
        return 0;
    }
}