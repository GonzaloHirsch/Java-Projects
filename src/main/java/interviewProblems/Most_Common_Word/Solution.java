package interviewProblems.Most_Common_Word;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        // Have all the banned words in a hashset for quick comparison
        Set<String> bannedWords = new HashSet<>();
        for (String word : banned) bannedWords.add(word);
        bannedWords.add(" ");

        // Build the frequency map
        Map<String, Integer> freq = new HashMap<>();
        String[] words = paragraph.replaceAll("[!?',;\\.]", " ").toLowerCase().split("\\s+");
        int max = 0, tmp;
        String maxS = null;
        for (String word : words) {
            if (!bannedWords.contains(word)) {
                tmp = freq.getOrDefault(word, 0) + 1;
                freq.put(word, tmp);
                if (tmp > max) {
                    max = tmp;
                    maxS = word;
                }
            }
        }

        return maxS;
    }
}