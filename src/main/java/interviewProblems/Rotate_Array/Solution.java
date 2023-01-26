package interviewProblems.Rotate_Array;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public void rotate(int[] nums, int k) {
        // Add all to the pending queue
        Queue<Integer> pending = new LinkedList<>();
        for (int i = 0; i < Math.min(k, nums.length); i++) pending.add(nums[i]);
        // Iterate and replace
        for (int i = 0, n = nums.length; i < nums.length; i++) {
            pending.add(nums[(i + k) % n]);
            nums[(i + k) % n] = pending.poll();
        }
    }
}