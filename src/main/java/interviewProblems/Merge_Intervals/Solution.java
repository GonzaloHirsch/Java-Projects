package interviewProblems.Merge_Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        // Base case no need to do anything
        if (intervals.length == 1) return intervals;
        // Sort the list to find the overlapping ones easier
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? Integer.compare(a[1],b[1]) : Integer.compare(a[0],b[0]));
        // List for the results
        List<int[]> result = new ArrayList<>();
        int i = 0, j = 1, low = -1, high = 0;
        while (i < intervals.length) {
            // Compute intersection
            if (j < intervals.length) {
                low = Math.max(intervals[i][0], intervals[j][0]);
                high = Math.min(intervals[i][1], intervals[j][1]);
            }
            // Check if indeed overlapping
            if (low <= high) {
                intervals[i][1] = Math.max(intervals[j][1], intervals[i][1]);
                j++;
                low = 1;
                high = 0;
            }
            // If not overlapping, move on
            else {
                result.add(intervals[i]);
                i = j;
                j = i + 1;
            }
        }
        return result.toArray(new int[0][0]);
    }
}