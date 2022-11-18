package interviewProblems.Split_Array_Into_Consecutive_Subsequences;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isPossible(int[] nums) {
        // Freq keeps track of the frequency of numbers
        // Length keeps track of the numbers available to be appended
        Map<Integer, Integer> freq = new HashMap<>(), lengths = new HashMap<>();
        // Count frequencies
        for (int num : nums) freq.put(num, freq.getOrDefault(num, 0) + 1);
        // Check if we can add it to other subsequences
        for (int num : nums) {
            // Check that the frequency of the number is not 0
            if (freq.get(num) == 0) continue;
                // If there is a sequence that can end in the number, add it
            else if (lengths.getOrDefault(num, 0) > 0) {
                lengths.put(num, lengths.get(num) - 1);
                lengths.put(num + 1, lengths.getOrDefault(num + 1, 0) + 1);
            }
            // If the number can start a new sequence
            else if (freq.getOrDefault(num + 1, 0) > 0 && freq.getOrDefault(num + 2, 0) > 0) {
                freq.put(num + 1, freq.get(num + 1) - 1);
                freq.put(num + 2, freq.get(num + 2) - 1);
                lengths.put(num + 3, lengths.getOrDefault(num + 3, 0) + 1);
            } else return false;
            // Reduce the frequency count
            freq.put(num, freq.get(num) - 1);
        }
        return true;
    }
}