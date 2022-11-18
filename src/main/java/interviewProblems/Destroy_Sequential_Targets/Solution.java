package interviewProblems.Destroy_Sequential_Targets;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public int destroyTargets(int[] nums, int space) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0, mod;
        for (int n : nums) {
            // Compute the mod for each one given the space and keep track of the maximum count
            mod = n % space;
            // Increment the mod count
            map.put(mod, map.getOrDefault(mod, 0) + 1);
            // Keep track of the maxium mod count
            max = Math.max(max, map.get(mod));
        }
        // Find the smallest element with same mod count
        int min = Integer.MAX_VALUE;
        for (int n : nums) if (map.get(n % space) == max) min = Math.min(n, min);
        return min;
    }
}