package interviewProblems.Trapping_Rain_Water;

public class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1, lmax = 0, rmax = 0, min, total = 0;

        while (l <= r){
            rmax = Math.max(height[r], rmax);
            lmax = Math.max(height[l], lmax);
            min = Math.min(lmax, rmax);

            if (height[l] < min){
                total += min - height[l];
                height[l] = min;
            }
            if (height[r] < min){
                total += min - height[r];
                height[r] = min;
            }

            if (rmax >= lmax){
                l++;
            }
            if (rmax <= lmax){
                r--;
            }
        }

        return total;
    }
}
