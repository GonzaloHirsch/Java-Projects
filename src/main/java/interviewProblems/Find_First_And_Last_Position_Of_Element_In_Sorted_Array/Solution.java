package interviewProblems.Find_First_And_Last_Position_Of_Element_In_Sorted_Array;
class Solution {
    public int[] searchRange(int[] nums, int target) {
        // Find in array
        int foundIndex = this.binarySearch(nums, target);
        // Discard if not found
        if (nums.length <= 0 || nums[0] > target || nums[nums.length - 1] < target || nums[foundIndex] != target) return new int[]{-1,-1};
        // Find the limits
        int l,r;
        for (l = foundIndex; l >= 0 && nums[l] == target; l--);
        for (r = foundIndex; r < nums.length && nums[r] == target; r++);
        return new int[]{l + 1, r - 1};
    }

    private int binarySearch(int[] nums, int target) {
        int l = 0, r = nums.length, mid;
        while (l < r) {
            mid = (l + r) / 2;
            if (target > nums[mid]) l = mid + 1;
            else if (target < nums[mid]) r = mid;
            else return mid;
        }
        return l;
    }
}