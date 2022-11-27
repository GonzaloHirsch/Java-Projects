package interviewProblems.Valid_Parentheses;
class Solution {
    public String reverseOnlyLetters(String s) {
        char[] chars = s.toCharArray();
        int l = 0, r = s.length() - 1;
        char tmp;
        while (l < r) {
            // If both english, it can be reversed
            if (this.isEnglish(chars[l]) && this.isEnglish(chars[r])) {
                tmp = chars[l];
                chars[l] = chars[r];
                chars[r] = tmp;
                l++;
                r--;
            }
            if (!this.isEnglish(chars[l])) l++;
            if (!this.isEnglish(chars[r])) r--;
        }
        return new String(chars);
    }

    private boolean isEnglish(char c) {
        return ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z');
    }
}