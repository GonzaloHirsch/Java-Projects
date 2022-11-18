package interviewProblems.Swap_For_Longest_Repeated_Character_Substring;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxRepOpt1(String text) {
        // Stores lengths of subsequences
        int[] totals = new int['z' - 'a' + 1];
        int[] seqs = new int[text.length()];
        char[] chars = text.toCharArray();
        char c = chars[0], maxC = chars[0], prevC = '.';
        int max = Integer.MIN_VALUE, tot = 0;
        // Iterate and perform all the counts
        for (int i = 0; i < seqs.length; i++) {
            c = chars[i];
            totals[c - 'a']++;
            seqs[i] = -1;
            tot++;
            if (i > 0 && c != prevC) {
                // Store totals in edges
                seqs[i - 1] = tot - 1;
                seqs[i - (tot - 1)] = tot - 1;
                // Keep track of max
                if (tot - 1 >= max && totals[prevC - 'a'] >= totals[maxC - 'a']) {
                    max = tot - 1;
                    maxC = prevC;
                }
                // Updates
                tot = 1;
            }
            prevC = c;
        }
        // Store the totals for the last letter
        seqs[seqs.length - 1] = tot;
        seqs[seqs.length - tot] = tot;
        if (tot >= max && totals[c - 'a'] >= totals[maxC - 'a']) {
            max = tot;
            maxC = c;
        }

        // Find if the biggest case of joining 2 is larger than
        int res = max + (totals[maxC - 'a'] > max ? 1 : 0);
        for (int i = 1, target; i < seqs.length - 1; i++) {
            // Have a candidate of the case aaabaaa
            if (seqs[i] == 1 && chars[i - 1] == chars[i + 1]) {
                target = seqs[i - 1] + seqs[i + 1];
                target += (totals[chars[i - 1] - 'a'] > target ? 1 : 0);
                if (target > res) {
                    res = target;
                }
            }
        }
        return res;
    }
}


