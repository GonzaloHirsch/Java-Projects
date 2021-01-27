package interviewProblems.Longest_Substring_Without_Repeating_Characters;

import java.util.HashMap;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> visited = new HashMap<Character, Integer>();
        int front = 0;
        int back = 0;
        Character actual;
        int longest = 0;
        while(front < s.length()){
            actual = s.charAt(front);
            if (visited.containsKey(actual) && visited.get(actual) >= back){
                back = visited.get(actual) + 1;
            }
            visited.put(actual, front);
            if (front - back + 1 > longest){
                longest = front - back + 1;
            }
            front++;
        }
        return longest;
    }
}
