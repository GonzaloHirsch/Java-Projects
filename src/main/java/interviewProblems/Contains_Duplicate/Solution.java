package interviewProblems.Contains_Duplicate;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> memo = new HashSet<>();
        for (int num : nums) {
            if (memo.contains(num)) return true;
            memo.add(num);
        }
        return false;
    }
}