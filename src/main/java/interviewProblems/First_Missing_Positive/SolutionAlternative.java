package interviewProblems.First_Missing_Positive;

class SolutionAlternative {
    public int firstMissingPositive(int[] nums) {
        // Mark all the not interesting values as Integer.MAX_VALUE
        for (int i = 0; i < nums.length; i++) if (nums[i] <= 0 || nums[i] > nums.length) nums[i] = Integer.MAX_VALUE;
        // Mark cells with a minus if the index exists, take into account the abs
        for (int i = 0; i < nums.length; i++)
            if (Math.abs(nums[i]) <= nums.length) nums[Math.abs(nums[i]) - 1] = -1 * Math.abs(nums[Math.abs(nums[i]) - 1]);
        // Look for the first positive number not Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) if (nums[i] > 0) return i + 1;
        return nums.length + 1;
    }
}