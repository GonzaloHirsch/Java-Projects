package interviewProblems.Maximum_Sum_Obtained_Of_Any_Permutation;

import java.util.Arrays;

class Solution {
    private final int MOD = (int)1e9 + 7;

    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        // Given we can have any permutation, we need to find the largest M numbers covered by requests
        // Find how many numbers the requests covers
        int[] counts = new int[nums.length];
        for (int[] request : requests) {
            counts[request[0]]++;
            if (request[1] + 1 < nums.length) counts[request[1] + 1]--;
        }
        // Propagate the counts
        for (int i = 1; i < counts.length; i++) counts[i] += counts[i - 1];
        // Sort the positions array to know how many times to count each one
        Arrays.sort(nums);
        // Sort the array to get the largest n numbers
        Arrays.sort(counts);
        // Count using the largest numbers but taking into account multiple appearances
        long res = 0;
        for (int i = 0; i < nums.length; i++) res += (long)nums[i] * counts[i];
        return (int)(res % MOD);
    }
}