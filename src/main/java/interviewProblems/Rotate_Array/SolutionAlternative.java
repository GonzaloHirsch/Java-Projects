package interviewProblems.Rotate_Array;

class SolutionAlternative {
    public void rotate(int[] nums, int k) {
        // Make sure K is less than N
        k = k % nums.length;
        if (k <= 0 || nums.length <= 1) return;
        // Apply reversions
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }

    private void reverse(int[] nums, int l, int r) {
        int tmp = 0;
        while (l < r) {
            tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            l++;
            r--;
        }
    }
}