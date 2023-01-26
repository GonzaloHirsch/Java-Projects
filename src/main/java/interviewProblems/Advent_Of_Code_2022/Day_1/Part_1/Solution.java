package interviewProblems.Advent_Of_Code_2022.Day_1.Part_1;

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
}