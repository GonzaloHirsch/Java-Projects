package interviewProblems.Advent_Of_Code_2022.Day_6.Part_2;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int detect (String input, int n) {
        char[] chars = input.toCharArray();
        Set<Character> set;
        for (int i = n - 1; i < chars.length; i++) {
            set = new HashSet<>();
            for (int j = 0; j < n && !set.contains(chars[i - j]); j++) set.add(chars[i - j]);
            if (set.size() == n) return i + 1;
        }
        return -1;
    }
}