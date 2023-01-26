package interviewProblems.Advent_Of_Code_2022.Day_10.Part_1;

public class Solution {
    public int findFrequency(String input) {
        String[] instructions = input.split("\n");
        int X = 1, total = 0, cycle = 1;

        // Iterate instructions
        for (String instruction : instructions) {
            // Check cycle is ok
            if ((cycle - 20) % 40 == 0 && cycle <= 220) total += (X * cycle);
            cycle++;
            // Evaluate instructions
            if (!instruction.equals("noop")) {
                if ((cycle - 20) % 40 == 0 && cycle <= 220) total += (X * cycle);
                cycle++;
                X += Integer.parseInt(instruction.split(" ")[1]);
            }
        }

        return total;
    }
}