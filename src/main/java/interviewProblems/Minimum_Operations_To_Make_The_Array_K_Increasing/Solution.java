package interviewProblems.Minimum_Operations_To_Make_The_Array_K_Increasing;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int kIncreasing(int[] arr, int k) {
        int total = 0;
        for (int i = 0; i < k; i++) {
            total += this.longDecSub(arr, i, k);
        }
        return arr.length - total;
    }

    private int longDecSub(int[] arr, int start, int k) {
        List<Integer> elems = new ArrayList<>();
        for (int i = start; i < arr.length; i += k) {
            if (elems.isEmpty() || elems.get(elems.size() - 1) <= arr[i]) {
                elems.add(arr[i]);
            } else {
                elems.set(upperBound(elems, arr[i]), arr[i]);
            }
        }
        return elems.size();
    }

    private int upperBound(List<Integer> list, int val) {
        int l = 0, r = list.size() - 1, m = 0;
        while (l < r) {
            m = (l + r) / 2;
            if (list.get(m) <= val) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }


    // DP version, clearly doesn't work given the problem bounds
    private int longDecSub(int[] arr, int index, int currentMax, int k) {
        // Base case
        if (index >= arr.length) return 0;
        // Choose options
        // Can only take number if number can be taken
        int takeNumber = -1, skipNumber = 0;
        if (arr[index] >= currentMax) {
            takeNumber = 1 + this.longDecSub(arr, index + k, arr[index], k);
        }
        skipNumber = this.longDecSub(arr, index + k, currentMax, k);
        // Keep the maximum
        return Math.max(takeNumber, skipNumber);
    }
}