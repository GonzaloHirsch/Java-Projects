package interviewProblems.Group_Anagrams;

import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Stores hashcode of each word
        Map<String, List<String>> map = new HashMap<>();
        List<String> words;
        char[] chars;
        String s;
        for (String str : strs) {
            chars = str.toCharArray();
            Arrays.sort(chars);
            s = new String(chars);
            words = map.getOrDefault(s, new ArrayList<>());
            words.add(str);
            map.put(s, words);
        }
        return new ArrayList<>(map.values());
    }
}