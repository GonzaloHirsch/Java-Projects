package interviewProblems.Construct_K_Palindrome_Strings;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean canConstruct(String s, int k) {
        // Base case, more palindromes than letters
        if (s.length() < k) return false;
        // Count frequencies
        int[] freq = new int['z' - 'a' + 1];
        char[] chars = s.toCharArray();
        for (char c : chars) freq[c - 'a']++;
        // Count even/odd frequencies
        int odd = 0;
        for (int f : freq) odd += (f % 2 != 0 ? 1 : 0);
        // Minimum number of palindromes built
        // Even letters can be joined together into 1 palindrome, 1 even + 1 odd can be joined into 1
        return k >= odd;
    }
}