package interviewProblems.Single_Element_In_A_Sorted_Array;
class Solution {
    public int singleNonDuplicate(int[] nums) {
        // If mid is even, the next one should be equal to the number
        // If mid is odd, the previous one should be equal
        // If those conditions are good, the extra is on the right hand side
        // Otherwise, extra is on the left hand side
        int l = 0, r = nums.length - 1, mid = 0;
        while (l < r) {
            mid = (l + r) / 2;
            if ((mid % 2 == 0 && nums[mid] == nums[mid + 1]) || (mid % 2 == 1 && nums[mid] == nums[mid - 1])) l = mid + 1;
            else r = mid;
        }
        return nums[l];
    }
}