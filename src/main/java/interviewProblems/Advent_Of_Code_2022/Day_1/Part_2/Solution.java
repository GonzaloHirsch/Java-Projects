package interviewProblems.Advent_Of_Code_2022.Day_1.Part_2;

import java.util.Stack;

public class Solution {
    public int getMaximumFromList(String s) {
        int max = 0, curr = 0;
        String[] numbers = s.split("\n");
        for (String num : numbers) {
            if (num.isEmpty()) {
                max = Math.max(max, curr);
                curr = 0;
            } else curr += Integer.parseInt(num);
        }
        return max;
    }

    public int getMaximumTopN(String s, int limit) {
        Stack<Integer> top3 = new Stack<>();
        int curr = 0;

        // Split and iterate the numbers
        String[] numbers = s.split("\n");
        for (String num : numbers) {
            if (num.isEmpty()) {
                // Check if the top of the stack is bigger than the number
                if (top3.isEmpty() || top3.size() < limit || top3.peek() < curr) this.addToStack(top3, curr, limit);
                // Reset curr
                curr = 0;
            } else curr += Integer.parseInt(num);
        }

        // Take care of the last number that didn't get taken care of because of no empty string
        if (top3.isEmpty() || top3.size() < limit || top3.peek() < curr) this.addToStack(top3, curr, limit);

        return this.getStackTotal(top3);
    }

    private int getStackTotal(Stack<Integer> stack) {
        int total = 0;
        while (!stack.isEmpty()) total += stack.pop();
        return total;
    }

    private void addToStack(Stack<Integer> stack, int number, int limit) {
        Stack<Integer> order = new Stack<>();
        // Add the numbers to the order while those are less than the one we want
        while (!stack.isEmpty() && stack.peek() < number) order.push(stack.pop());
        // Add the number to the og stack
        stack.push(number);
        // Add back the other numbers
        while (stack.size() < limit && !order.isEmpty()) stack.push(order.pop());
    }
}