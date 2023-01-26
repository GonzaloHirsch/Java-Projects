package interviewProblems.Advent_Of_Code_2022.Day_2.Part_1;

import java.util.HashMap;

public class Solution {
    private HashMap<Character, Integer> SHAPE_SCORES;
    private HashMap<String, Integer> COMBO_SCORES;

    public int getMaxScore(String input) {
        this.computeMaps();
        int max = 0;
        String[] rounds = input.split("\n");
        for (String round : rounds) {
            // Count the outcome
            max += this.COMBO_SCORES.getOrDefault(round, 0);
            // Count what you selected
            max += this.SHAPE_SCORES.get(round.split(" ")[1].charAt(0));
        }
        return max;
    }

    private void computeMaps() {
        // shape you selected (1 for Rock, 2 for Paper, and 3 for Scissors)
        this.SHAPE_SCORES = new HashMap<>();
        this.SHAPE_SCORES.put('X', 1);
        this.SHAPE_SCORES.put('Y', 2);
        this.SHAPE_SCORES.put('Z', 3);
        // outcome of the round (0 if you lost, 3 if the round was a draw, and 6 if you won)
        this.COMBO_SCORES = new HashMap<>();
        // Draw
        this.COMBO_SCORES.put("A X", 3);
        this.COMBO_SCORES.put("B Y", 3);
        this.COMBO_SCORES.put("C Z", 3);
        // WIN
        this.COMBO_SCORES.put("A Y", 6);
        this.COMBO_SCORES.put("B Z", 6);
        this.COMBO_SCORES.put("C X", 6);
        // Otherwise it's lost
    }
}