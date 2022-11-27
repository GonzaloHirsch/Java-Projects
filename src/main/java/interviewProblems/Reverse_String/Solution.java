package interviewProblems.Reverse_String;


class Solution {
    public void reverseString(char[] s) {
        char tmp;
        for (int i = 0, n = s.length; i < n / 2; i++) {
            tmp = s[i];
            s[i] = s[n - i - 1];
            s[n - i - 1] = tmp;
        }
    }
}
