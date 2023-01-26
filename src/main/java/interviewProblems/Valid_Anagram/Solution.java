package interviewProblems.Valid_Anagram;


class Solution {
    public boolean isAnagram(String s, String t) {
        int[] letters = new int['z' - 'a' + 1];
        char[] arrS = s.toCharArray(), arrT = t.toCharArray();
        // Fill the letters initially
        for (char c : arrS) letters[c - 'a']++;
        // Decrease the letters
        for (char c : arrT) letters[c - 'a']--;
        // Check if any letters is not 0
        for (int letter : letters) if (letter != 0) return false;
        return true;
    }
}