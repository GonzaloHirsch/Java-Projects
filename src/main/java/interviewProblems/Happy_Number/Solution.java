package interviewProblems.Happy_Number;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<>();
        while (!visited.contains(n)) {
            visited.add(n);
            n = this.computeValue(n);
            if (n == 1) return true;
        }
        return false;
    }

    private int computeValue(int n) {
        int val = 0;
        while (n > 0) {
            val += Math.pow(n % 10, 2);
            n /= 10;
        }
        return val;
    }
}