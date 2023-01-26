package interviewProblems.Advent_Of_Code_2022.Day_6.Part_1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int detectNSubsequence(String input, int n) {
        int curr = 0;
        char[] chars = input.toCharArray();
        // Fill the positions with -1
        int[] pos = new int['z' - 'a' + 1];
        Arrays.fill(pos, -1);
        // Iterate and find sequence
        for (int i = 0; i < chars.length; i++) {
            // Check break condition
            if (curr == n) return i;
            // Check if character is repeated within 4 sequence
            if (pos[chars[i] - 'a'] < 0 || (pos[chars[i] - 'a'] >= 0 && i - pos[chars[i] - 'a'] >= n)) curr++;
            else curr = Math.min(curr, i - pos[chars[i] - 'a']);
            // Store the latest position
            pos[chars[i] - 'a'] = i;
        }

        return -1;
    }

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