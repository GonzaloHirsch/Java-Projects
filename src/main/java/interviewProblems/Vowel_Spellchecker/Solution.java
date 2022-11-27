package interviewProblems.Vowel_Spellchecker;


import java.util.*;

class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        // Used to check for exact matches
        Set<String> exactWords = new HashSet<>(Arrays.asList(wordlist));

        // Map to contain insensitive variants
        // Maps lowercase word to first instance of the word
        Map<String, Integer> alteredVersions = new HashMap<>();
        for (int i = 0; i < wordlist.length; i++) {
            alteredVersions.putIfAbsent(wordlist[i].toLowerCase(), i);
            // Generate vowel variants
            alteredVersions.putIfAbsent(this.generateSpecialVariant(wordlist[i].toLowerCase()), i);
        }


        String[] matches = new String[queries.length];
        String curr;

        for (int i = 0; i < queries.length; i++) {
            curr = queries[i];
            // Check for exact match
            if (exactWords.contains(curr)) matches[i] = queries[i];
            else {
                curr = curr.toLowerCase();
                // Check for case match
                if (alteredVersions.containsKey(curr)) matches[i] = wordlist[alteredVersions.get(curr)];
                else {
                    curr = this.generateSpecialVariant(curr);
                    if (alteredVersions.containsKey(curr)) matches[i] = wordlist[alteredVersions.get(curr)];
                    else matches[i] = "";
                }
            }
        }

        return matches;
    }

    private String generateSpecialVariant(String s) {
        return s.replaceAll("[aeiou]", "-");
    }
}