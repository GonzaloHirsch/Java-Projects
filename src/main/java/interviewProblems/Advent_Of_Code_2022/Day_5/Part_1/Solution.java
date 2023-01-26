package interviewProblems.Advent_Of_Code_2022.Day_5.Part_1;

import java.util.List;
import java.util.Stack;

public class Solution {
    public String getOutcome(List<Stack<Character>> stacks, List<int[]> instructions) {
        // Iterate the instructions
        Stack<Character> from, to;
        for (int[] instruction : instructions) {
            // Move all the items
            from = stacks.get(instruction[1] - 1);
            to = stacks.get(instruction[2] - 1);
            for (int i = 0; i < instruction[0]; i++) if (!from.isEmpty()) to.push(from.pop());
        }

        return this.getTopOfStacks(stacks);
    }

    private String getTopOfStacks(List<Stack<Character>> stacks) {
        StringBuilder sb = new StringBuilder();
        for (Stack<Character> stack : stacks) sb.append(stack.peek());
        return sb.toString();
    }
}