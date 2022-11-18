package interviewProblems.Height_Checker;

import java.util.*;

class Solution {
    public int heightChecker(int[] heights) {
        int[] expected = heights;
        // Make a copy of the heights
        int[] actual = new int[heights.length];
        for (int i = 0; i < expected.length; i++) actual[i] = expected[i];
        // Sort the expected value
        Arrays.sort(expected);
        // Count
        int res = 0;
        for (int i = 0; i < expected.length; i++) res += (actual[i] != expected[i]) ? 1 : 0;
        return res;
    }
}



