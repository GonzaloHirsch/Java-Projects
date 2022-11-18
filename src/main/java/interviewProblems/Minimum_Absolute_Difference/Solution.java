package interviewProblems.Minimum_Absolute_Difference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> minimumAbsDifference(final int[] arr) {
        // nlogn to sort
        Arrays.sort(arr);
        // Find the minimum diff
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) min = Math.min(min, arr[i + 1] - arr[i]);
        // Look for pairs that have that sum
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length && arr[j] - arr[i] <= min; j++) {
                if (arr[j] - arr[i] == min) res.add(Arrays.asList(arr[i],arr[j]));
            }
        }
        return res;
    }
}