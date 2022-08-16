package interviewProblems.Minimum_Average_Difference;
class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length, minimumI = 0;
        // Calculate initial values
        long left = 0, right = 0, sum = 0, min = Integer.MAX_VALUE, tmp;
        for (int num : nums) sum += num;
        // Iterate to find min
        for (int i = 0; i < n; i++) {
            // Change sum values
            left += nums[i];
            right = sum - left;
            // Check for new minimum
            tmp = Math.abs((long)(left / (i+1)) - ((long) right / (i == n - 1 ? 1 : n-i-1)));
            if (tmp < min) {
                min = tmp;
                minimumI = i;
            }
        }
        return minimumI;
    }
}