package interviewProblems.First_Missing_Positive;

public class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int i = 0;

        // Make sure each number corresponds to index
        while (i < n){
            if (nums[i] >= 0 && nums[i] < n && nums[nums[i]] != nums[i])
                swap(nums, i, nums[i]);
            else
                i++;
        }

        int k = 1;
        while (k < n && nums[k] == k) {k++;}

        if (n == 0 || k < n)
            return k;
        else
            return nums[0] == k ? k + 1: k;
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
