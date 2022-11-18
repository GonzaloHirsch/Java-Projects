package interviewProblems.Long_Pressed_Name;

import java.util.Arrays;

class Solution {
    public boolean isLongPressedName(String name, String typed) {
        if (name.length() > typed.length()) return false;

        char[] _name = name.toCharArray(), _typed = typed.toCharArray();
        int n = _name.length - 1, t = _typed.length - 1;
        char nPrev = '.', tPrev = '.';
        while (t >= 0) {
            // If same letter, move ahead
            if (n >= 0 && _name[n] == _typed[t]) {
                nPrev = _name[n--];
                tPrev = _typed[t--];
            }
            // If current typed letter is the same as the previous name one, it's ok
            else if (_typed[t] == nPrev) {
                tPrev = _typed[t--];
            }
            // If the current name letter is the same as the previous name one, it's not ok
            else return false;
        }

        return n < 0;
    }
}