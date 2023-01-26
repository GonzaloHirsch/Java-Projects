package interviewProblems.Remove_Duplicates_From_Sorted_Array;


class Solution {
    public int removeDuplicates(int[] nums) {
        int insert = 1;
        for (int i = 1; i < nums.length; i++) if (nums[i] != nums[i - 1]) nums[insert++] = nums[i];
        return insert;
    }
}