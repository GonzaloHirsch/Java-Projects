package interviewProblems.Valid_Mountain_Array;

import java.util.*;

class Solution {
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) return false;
        boolean shouldIncrease = true, increased = false;
        for (int i = 1; i < arr.length; i++) {
            // Strict increasing
            if (arr[i] > arr[i - 1]) {
                increased = true;
                if (!shouldIncrease) return false;
            }
            // Strict decrease and should increase, ideally we found the top
            else if (arr[i] < arr[i - 1] && shouldIncrease) shouldIncrease = false;
                // Cannot have equals
            else if (arr[i] == arr[i - 1]) return false;
        }
        return increased && !shouldIncrease;
    }
}
