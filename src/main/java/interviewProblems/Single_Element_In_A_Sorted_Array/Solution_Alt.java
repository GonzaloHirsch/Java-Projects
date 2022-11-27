package interviewProblems.Single_Element_In_A_Sorted_Array;
class Solution_Alt {
    public int singleNonDuplicate(int[] nums) {
        int l = 0, r = nums.length - 1, mid = 0;
        while (l < r - 1) {
            mid = (l + r) / 2;
            // On even indexes, the element should be different to the previous one
            // On odd indexes, the element should be equal to the previous one
            if (mid % 2 == 0) {
                if (nums[mid] == nums[mid - 1]) r = mid - 1;
                else l = mid;
            } else {
                if (nums[mid] == nums[mid - 1]) l = mid + 1;
                else r = mid;
            }
        }
        return nums[l];
    }
}