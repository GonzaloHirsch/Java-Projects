package interviewProblems.Reduction_Operations_To_Make_The_Array_Elements_Equal;

import java.util.Arrays;

class Solution {
    public int reductionOperations(int[] nums) {
        // Sort the array in ascending order
        Arrays.sort(nums);

        // Count all the changes required
        int total = 0, n = nums.length;
        for (int i = 1, stepOperations = 0; i < n; i++) {
            if (nums[i - 1] != nums[i]) stepOperations++;
            total += stepOperations;
        }

        return total;
    }
}