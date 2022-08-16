package interviewProblems.Form_Array_By_Concatenating_Subarrays_Of_Another_Array;

import java.util.HashMap;
import java.util.Map;
class Solution {
    public boolean canChoose(int[][] groups, int[] nums) {
        // Check if subarrays can be found
        boolean found, match, res = true;
        int numsI = 0;
        // Iterate all groups
        for (int group = 0; group < groups.length && res; group++) {
            found = false;
            // Iterate all numbers until we find the group
            while (numsI < nums.length && !found) {
                match = true;
                // Iterate elements of the group until we mismatch
                for (int groupI = 0; groupI < groups[group].length && match; groupI++) {
                    if ((numsI + groupI >= nums.length) || (groups[group][groupI] != nums[numsI + groupI])) match = false;
                }
                // If it was a match, it was foudn and can move on
                found = match;
                if (match) numsI += groups[group].length;
                else numsI++;
            }
            // If it wasn't found, we can stop all
            res = found;
        }
        return res;
    }
}