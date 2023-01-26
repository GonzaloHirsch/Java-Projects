package interviewProblems.Advent_Of_Code_2022.Day_3.Part_1;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int findPrioritySum(String input) {
        int total = 0, half;
        String[] sacks = input.split("\n");
        char[] items;
        Set<Character> inventory;
        for (String sack : sacks) {
            // Get the items and iterate them
            items = sack.toCharArray();
            inventory = new HashSet<>();
            // Compute middle part
            half = items.length / 2;
            for (int i = 0; i < items.length; i++) {
                // First half
                if (i < half) inventory.add(items[i]);
                // Second half
                else if (inventory.contains(items[i])) {
                    total += (items[i] > 'Z' ? items[i] - 'a' + 1 : items[i] - 'A' + 27);
                    break;
                }
            }
        }

        return total;
    }
}