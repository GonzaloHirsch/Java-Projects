package interviewProblems.Advent_Of_Code_2022.Day_10.Part_2;

public class Solution {
    public String drawScreen(String input) {
        String[] instructions = input.split("\n");
        int X = 1, pixel = 0;
        StringBuilder sb = new StringBuilder();

        // Iterate instructions
        for (String instruction : instructions) {
            // Check cycle is ok
            sb.append(pixel % 40 == 0 ? '\n' : "").append(this.getCurrentPixel(pixel, X));
            pixel = (pixel + 1) % 40;
            // Evaluate instructions
            if (!instruction.equals("noop")) {
                sb.append(pixel % 40 == 0 ? '\n' : "").append(this.getCurrentPixel(pixel, X));
                pixel = (pixel + 1) % 40;
                X += Integer.parseInt(instruction.split(" ")[1]);
            }
        }

        return sb.toString();
    }

    private char getCurrentPixel(int pixel, int X) {
        return Math.abs(pixel - X) <= 1 ? '#' : '.';
    }
}