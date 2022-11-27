package interviewProblems.Element_Appearing_More_Than_25_In_Sorted_Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* NOTE: It can be improved with binary search */
class Solution {
    public int findSpecialInteger(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        int max = 0, maxN = 0;
        for (int n : arr) {
            // Count for frequency
            freq.put(n, freq.getOrDefault(n, 0) + 1);
            if (freq.get(n) > max) {
                max = freq.get(n);
                maxN = n;
            }
        }
        return maxN;
    }
}