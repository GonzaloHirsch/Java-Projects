package interviewProblems.Advent_Of_Code_2022.Day_4.Part_2;

public class Solution {
    public int findOverlappingPairs(String input) {
        int total = 0, overlap;
        String[] pairs = input.split("\n"), ranges, range;
        int[][] tasks;
        for (String pair : pairs) {
            ranges = pair.split(",");
            tasks = new int[2][];
            // Compute the ranges
            for (int i = 0; i < ranges.length; i++) {
                range = ranges[i].split("-");
                tasks[i] = new int[]{Integer.parseInt(range[0]), Integer.parseInt(range[1])};
            }
            // Determine the overlap
            overlap = Math.min(tasks[0][1], tasks[1][1]) - Math.max(tasks[0][0], tasks[1][0]) + 1;
            // Just count if there's any overlap at all
            if (overlap > 0) total++;
        }

        return total;
    }
}