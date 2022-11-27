package interviewProblems.Roman_To_Integer;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int total = 0;
        char prev = 0;
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case 'I':
                    total++;
                    break;
                case 'V':
                    total += 5;
                    if (prev == 'I') total -= 1 * 2;
                    break;
                case 'X':
                    total += 10;
                    if (prev == 'I') total -= 1 * 2;
                    break;
                case 'L':
                    total += 50;
                    if (prev == 'X') total -= 10 * 2;
                    break;
                case 'C':
                    total += 100;
                    if (prev == 'X') total -= 10 * 2;
                    break;
                case 'D':
                    total += 500;
                    if (prev == 'C') total -= 100 * 2;
                    break;
                case 'M':
                    total += 1000;
                    if (prev == 'C') total -= 100 * 2;
                    break;
            }
            prev = chars[i];
        }
        return total;
    }
}