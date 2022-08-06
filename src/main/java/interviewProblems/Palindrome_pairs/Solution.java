package interviewProblems.Palindrome_pairs;

import java.util.*;

class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        int n = words.length;
        // Precompute reversions
        Map<String, Integer> reversed = new HashMap<>();
        for (int i = 0; i < n; i++) {
            reversed.put(reverse(words[i]), i);
        }
        // Iterate and find pairs
        String curr,sub1,sub2;
        int length, targetIndex;
        for (int i = 0; i < n; i++) {
            curr = words[i];
            length = curr.length();
            for (int cut = 0; cut <= length; cut++) {
                // If s1[0:cut] is palindrome and s1[cut+1] = reverse(some s2), then s2 + s1 works
                sub1 = curr.substring(0, cut);
                sub2 = curr.substring(cut);
                if (isPalindrome(sub1)) {
                    targetIndex = reversed.getOrDefault(sub2,i);
                    if (targetIndex != i) {
                        res.add(Arrays.asList(targetIndex, i));
                    }
                }
                // If s1[cut + 1:] is palindrome and s1[0:cut] = reverse(some s2), then s + s2 works
                if (sub2.length() > 0 && isPalindrome(sub2)) {
                    targetIndex = reversed.getOrDefault(sub1,i);
                    if (targetIndex != i) {
                        res.add(Arrays.asList(i, targetIndex));
                    }
                }
            }
        }
        return res;
    }

    private String reverse(String word) {
        return new StringBuilder(word).reverse().toString();
    }

    private boolean isPalindrome(String word) {
        int n = word.length();
        for (int i = 0; i < n / 2; i++) {
            if (word.charAt(i) != word.charAt(n - 1 - i)) return false;
        }
        return true;
    }
}