package interviewProblems.Shuffle_The_Array;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[nums.length];
        for (int i = 0, idx = 0; i < nums.length; i++) {
            res[2 * (i % n) + ((int) i / n)] = nums[i];
        }
        return res;
    }
}