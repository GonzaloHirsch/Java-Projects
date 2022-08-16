package interviewProblems.Sum_Of_Even_Numbers_After_Queries;

class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int[] result = new int[nums.length];
        int sum = 0, targetValue, index;
        // Precompute the sum
        for (int n : nums) sum += (n % 2 == 0 ? n : 0);
        // Iterate and apply queries
        for (int i = 0; i < queries.length; i++) {
            index = queries[i][1];
            targetValue = queries[i][0] + nums[index];
            // If new value is even, remove the previous and add the new one
            // If new value is not even, just remove from the sum the previous value
            sum = sum  - (nums[index] % 2 == 0 ? nums[index] : 0) + (targetValue % 2 == 0 ? targetValue : 0);
            // Update nums
            nums[index] = targetValue;
            // Store result
            result[i] = sum;
        }
        return result;
    }
}