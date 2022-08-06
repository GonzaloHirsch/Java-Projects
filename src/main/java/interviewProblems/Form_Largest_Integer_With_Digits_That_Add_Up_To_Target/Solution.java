package interviewProblems.Form_Largest_Integer_With_Digits_That_Add_Up_To_Target;

import java.util.HashSet;
import java.util.Set;
class Solution {
    public String largestNumber(int[] cost, int target) {
        Set<Integer> memory = new HashSet<>();
        // Optimize by killing repeated or invalid costs
        for (int i = 8; i >= 0; i--) {
            // If the cost is already present, no need to evaluate extra numbers
            // Cancel larger costs too
            if (cost[i] <= target && !memory.contains(cost[i])) {
                memory.add(cost[i]);
            } else {
                cost[i] = 0;
            }
        }
        String[][] dp = new String[10][target + 1];
        String res = this.search(1, target, cost, dp);
        return res == "" ? "0" : res;
    }

    private String search(int currentNumber, int remain, int[] cost, String[][] dp) {
        // Handle win/lose cases
        if (remain == 0) return "";
        else if (remain < 0 || currentNumber >= 10) return "0";
            // If the cost was killed by a larger number, use another number instead
        else if (cost[currentNumber - 1] == 0) return this.search(currentNumber + 1, remain - cost[currentNumber - 1], cost, dp);
        // Dynamic Programming memory to avoid repeated states
        if (dp[currentNumber][remain] != null) return dp[currentNumber][remain];
        // Make decision to take the number or go to the next one
        // Taking number involves choosing the number, resetting the index and decreasing the remain
        String numberToTake = currentNumber + this.search(1, remain - cost[currentNumber - 1], cost, dp);
        // Trying next one involves increasing the number index and not the remain
        String numberToPass = this.search(currentNumber + 1, remain, cost, dp);
        // Storing the result in the DP state
        dp[currentNumber][remain] = getLargestString(numberToTake, numberToPass);
        return dp[currentNumber][remain];
    }

    private String getLargestString(String a, String b) {
        if (a.contains("0")) return b;
        else if (b.contains("0")) return a;
        else if (a.length() > b.length()) return a;
        else if (a.length() < b.length()) return b;
        else return a.compareTo(b) > 1 ? a : b;
    }
}