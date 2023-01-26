package interviewProblems.Advent_Of_Code_2022.Day_2.Part_2;
import java.util.HashMap;

public class Solution {
    private final int[] SHAPE_SCORES = new int[]{1,2,3};
    private final int[] OUTCOME_SCORES = new int[]{0,3,6};

    public int getMaxScore(String input) {
        int total = 0;
        String[] rounds = input.split("\n");
        char shape, outcome;
        for (String round : rounds) {
            // Split to get the parts
            shape = round.charAt(0);
            outcome = round.charAt(2);
            // Count the outcome
            total += this.OUTCOME_SCORES[outcome - 'X'];
            // Determine what you have to choose based on the desired outcome
            switch (outcome) {
                // Lose
                case 'X':
                    total += this.SHAPE_SCORES[(shape - 'A' - 1 + this.SHAPE_SCORES.length) % this.SHAPE_SCORES.length];
                    break;
                // Draw
                case 'Y':
                    total += this.SHAPE_SCORES[shape - 'A'];
                    break;
                // Win
                case 'Z':
                    total += this.SHAPE_SCORES[(shape - 'A' + 1) % this.SHAPE_SCORES.length];
                    break;
            }
        }
        return total;
    }
}