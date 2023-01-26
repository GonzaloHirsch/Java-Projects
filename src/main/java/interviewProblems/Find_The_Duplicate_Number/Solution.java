package interviewProblems.Find_The_Duplicate_Number;

class Solution {
    public int findDuplicate(int[] nums) {
        // Use 2 pointers, slow/fast (tortoise/hare)
        int slow = 0, fast = 0;
        while (true) {
            // Fast moves twice as fast than slow
            slow = nums[slow];
            fast = nums[nums[fast]];
            // Found the cycle, next step is looking for entrance
            if (slow == fast) {
                fast = 0;
                while (slow != fast) {
                    slow = nums[slow];
                    fast = nums[fast];
                }
                return fast;
            }
        }
    }
}