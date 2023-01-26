package interviewProblems.Longest_Substring_Without_Repeating_Characters;

import java.util.HashMap;
import java.util.Map;

class SolutionAlternative {
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) return 0;
        Map<Character, Integer> letters = new HashMap<>();
        int l = 0, r = -1, max = 1;
        boolean valid = true;
        char c;
        while (l <= s.length() && r <= s.length()) {
            // If the current config is valid, try to expand to the right
            if (valid) {
                r++;
                if (r < s.length()) {
                    c = s.charAt(r);
                    letters.put(c, letters.getOrDefault(c, 0) + 1);
                    valid = letters.get(c) <= 1;
                }
                if (r <= s.length()) max = Math.max(r - l, max);
            }
            // Contract from the left
            else {
                l++;
                if (l < s.length() && l <= r) {
                    c = s.charAt(l - 1);
                    letters.put(c, letters.getOrDefault(c, 0) - 1);
                    valid = letters.values().stream().filter(n -> n > 1).count() == 0;
                }
            }
        }
        return max;
    }
}