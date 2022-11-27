package interviewProblems.Minimum_Space_Wasted_From_Packaging;


import java.util.*;

class Solution {
    private static long MOD = (int)Math.pow(10, 9) + 7;

    public int minWastedSpace(int[] packages, int[][] boxes) {
        // Compute maximum package and sort
        Arrays.sort(packages);
        int maxPackage = packages[packages.length - 1];
        long sumPackages = 0;
        for (int pkg : packages) sumPackages += (long)pkg;

        // Filter suppliers according to the maximum box size and sort
        List<int[]> suppliers = new ArrayList<>();
        for (int[] supplier : boxes) {
            int max = 0;
            for (int box : supplier) max = Math.max(max, box);
            if (max >= maxPackage) {
                Arrays.sort(supplier);
                suppliers.add(supplier);
            }
        }
        if (suppliers.isEmpty()) return -1;

        // Iterate suppliers to find maximum
        long waste = Long.MAX_VALUE, sum = Long.MAX_VALUE;
        int target = 0, prevTarget = 0;
        for (int[] supplier : suppliers) {
            sum = 0;
            prevTarget = 0;
            for (int box : supplier) {
                target = this.binarySearch(packages, box + 1);
                sum += ((long)(target - prevTarget) * (long)box);
                prevTarget = target;
            }
            waste = Math.min(waste, sum);
        }
        return (int)((waste - sumPackages) % MOD);
    }

    private int binarySearch(int[] arr, int target) {
        int l = 0, r = arr.length, mid = 0;
        while (l < r) {
            mid = (l + r) / 2;
            if (arr[mid] >= target) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}