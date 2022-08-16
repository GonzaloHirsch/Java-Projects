package interviewProblems.Wiggle_Subsequence;
class Solution {
    public int wiggleMaxLength(int[] nums) {
        // Creating the up/down arrays
        int[] up = new int[nums.length], down = new int[nums.length];
        up[0] = 1;
        down[0] = 1;
        // Iterating through the numbers
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                up[i] = down[i - 1] + 1;
                down[i] = down[i - 1];
            } else if (nums[i] < nums[i - 1]) {
                up[i] = up[i - 1];
                down[i] = up[i - 1] + 1;
            } else {
                up[i] = up[i - 1];
                down[i] = down[i - 1];
            }
        }
        return Math.max(up[nums.length - 1], down[nums.length - 1]);
    }
}