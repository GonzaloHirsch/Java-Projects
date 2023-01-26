package interviewProblems.Find_Peak_Element;
class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;
        int l = 0, r = nums.length, mid = 0;
        while (l < r) {
            mid = (l + r) / 2;
            if (mid > 0 && mid < nums.length - 1) {
                if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) return mid;
                else if (nums[mid] <= nums[mid + 1]) l = mid;
                else r = mid;
            } else if (mid <= 0) {
                if (nums[mid] > nums[mid + 1]) return mid;
                else l = mid;
            } else {
                if (nums[mid] > nums[mid - 1]) return mid;
                else r = mid;
            }
        }
        return mid;
    }
}