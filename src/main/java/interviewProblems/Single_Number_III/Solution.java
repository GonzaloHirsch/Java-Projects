package interviewProblems.Single_Number_III;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] singleNumber(int[] nums) {
        // No need to compute anything
        if (nums.length == 2) return nums;
        // Computing the XOR
        int xor = 0;
        for (int num : nums) xor ^= num;
        // Finding the index of the first set bit
        xor &= ~(xor - 1);
        // Iterate on numbers that have that bit set to 1
        int num1 = 0, num2 = 0;
        for (int num : nums) {
            if ((xor & num) == 0) num1 = num1 ^ num;
            else num2 = num2 ^ num;
        }
        return new int[]{num1, num2};
    }
}