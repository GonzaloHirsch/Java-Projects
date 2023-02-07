package interviewProblems.Maximum_Product_Subarray;

class Solution {
    public int maxProduct(int[] nums) {
        int l = 1, r = 1, max = Integer.MIN_VALUE, n = nums.length;
        for (int i = 0; i < n; i++) {
            // Reset if got 0
            l = l == 0 ? 1 : l;
            r = r == 0 ? 1 : r;
            // Accumulate multiplication
            l *= nums[i];
            r *= nums[n - 1 - i];
            // Update max
            max = Math.max(max, Math.max(l, r));
        }
        return max;
    }

    public int maxProductSlidingWindow(int[] nums) {
        /*
            Brute force: Sliding Window, TLE
         */
        int max = Integer.MIN_VALUE;
        // Iterate window sizes
        for (int wl = nums.length; wl >= 1; wl--) {
            // Iterate all windows within that size
            for (int w = 0; w < nums.length - wl + 1; w++) {
                // Iterate elements in window
                int mult = 1;
                for (int i = w; i < w + wl; i++) mult *= nums[i];
                max = Math.max(max, mult);
            }
        }
        return max;
    }
}