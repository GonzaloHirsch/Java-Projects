package interviewProblems.Top_K_Frequent_Words;

import java.util.*;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // Create and fill frequency map
        Map<String, Integer> frequency = new TreeMap<>();
        for (String word : words) frequency.put(word, frequency.getOrDefault(word, 0) + 1);
        // Create the sorted list and add the entries
        TreeSet<Map.Entry<String, Integer>> sortedEntries = new TreeSet<>((a, b) -> {
            int val = b.getValue() - a.getValue();
            return val == 0 ? a.getKey().compareTo(b.getKey()) : val;
        });
        sortedEntries.addAll(frequency.entrySet());
        // Get top k
        int ki = 0;
        List<String> result = new ArrayList<>();
        while (!sortedEntries.isEmpty() && ki < k) {
            result.add(sortedEntries.pollFirst().getKey());
            ki++;
        }
        return result;
    }
}