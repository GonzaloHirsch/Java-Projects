package interviewProblems.Partition_Labels;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<Integer> partitionLabels(String s) {
        // Count frequencies of each letter
        char[] chars = s.toCharArray();
        char[] freq = new char['z' - 'a' + 1];
        for (char c : chars) freq[c - 'a']++;

        // Iterate and check whether or not the entire count of letters at that point is reached
        List<Integer> res = new ArrayList<>();
        Set<Character> letters = new HashSet<>();
        boolean canDivide;
        int start = 0;
        for (int i = 0; i < chars.length; i++) {
            // Reduce frequency and add to set
            freq[chars[i] - 'a']--;
            letters.add(chars[i]);

            // Check if all letters in set have zero freq
            canDivide = true;
            for (char c : letters) if (freq[c - 'a'] > 0) canDivide = false;
            if (canDivide) {
                letters.clear();
                res.add(i - start + 1);
                start = i + 1;
            }
        }
        return res;
    }
}