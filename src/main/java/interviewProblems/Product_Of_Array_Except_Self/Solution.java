package interviewProblems.Product_Of_Array_Except_Self;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        // Get the multiplications up to the certain point
        int[] left = nums.clone(), right = nums.clone();
        for (int i = 1; i < left.length; i++) left[i] *= left[i - 1];
        for (int i = right.length - 2; i >= 0; i--) right[i] *= right[i + 1];

        // Compute everything
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) nums[i] = right[i + 1];
            else if (i == nums.length - 1) nums[i] = left[i - 1];
            else nums[i] = left[i - 1] * right[i + 1];
        }
        return nums;
    }
}