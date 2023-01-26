package interviewProblems.Three_Sum;

import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // Sort the array
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        // We look for nums[j] + nums[k] = nums[i]
        for (int i = 0, front = 0, back = 0, target = 0, f1, f2, sum; i < nums.length; i++) {
            target = -nums[i];
            front = i + 1;
            back = nums.length - 1;
            while (front < back) {
                // Checking for the sum
                sum = nums[front] + nums[back];
                // Comparing against the target
                if (sum < target) front++;
                else if (sum > target) back--;
                    // Found solution
                else {
                    // Storing the result
                    f1 = nums[front]; f2 = nums[back];
                    result.add(Arrays.asList(nums[i], nums[front], nums[back]));
                    // Removing duplicates of each of the numbers
                    while (front < back && nums[front] == f1) front++;
                    while (front < back && nums[back] == f2) back--;
                }
            }
            // Removing duplicates of the first number
            while (i < nums.length - 1 && nums[i + 1] == nums[i]) i++;
        }

        return result;
    }
}