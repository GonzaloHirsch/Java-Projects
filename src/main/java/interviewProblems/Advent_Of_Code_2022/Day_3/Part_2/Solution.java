package interviewProblems.Advent_Of_Code_2022.Day_3.Part_2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Solution {
    public int findPrioritySum(String input) {
        int total = 0, val;
        String[] sacks = input.split("\n");
        char[] items;
        Map<Character, Integer> group = new HashMap<>();
        for (int i = 0; i < sacks.length; i++) {
            // New group, reset map
            if (i % 3 == 0) group = new HashMap<>();
            // Iterate group
            items = sacks[i].toCharArray();
            for (char c : items) {
                val = group.getOrDefault(c, 0) | (1 << i % 3);
                // Add the item
                group.put(c, val);
                // Check if the count is met, 111
                if (val == 7) {
                    total += this.getPriority(c);
                    break;
                }
            }
        }
        return total;
    }

    private int getPriority(char c) {
        return c > 'Z' ? c - 'a' + 1 : c - 'A' + 27;
    }
}