package interviewProblems.Corporate_Flight_Bookings;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        // Responses will be stored here
        int[] res = new int[n];

        // Build a structure for returning a response
        // Will add a +seats to the start of the range
        // And a -seats to the end of the range + 1
        for (int[] book : bookings) {
            res[book[0] - 1] += book[2];
            // The range + 1 is included because bookings are 1-indexed
            if (book[1] < n) res[book[1]] -= book[2];
        }

        // Just accumulate over time the values
        for (int i = 1; i < n; ++i) res[i] += res[i - 1];

        return res;
    }
}