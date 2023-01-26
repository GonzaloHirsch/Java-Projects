package interviewProblems.Container_With_Most_Water;

class Solution {
    public int maxArea(int[] height) {
        int max = 0, l = 0, r = height.length - 1;
        while (l < r) {
            // Compute max
            max = Math.max(max, Math.min(height[l], height[r]) * (r - l));
            // Attempt to find someone larger depending on the side
            if (height[l] < height[r]) l++;
            else r--;
        }
        return max;
    }

    /*
    // This solution is the same idea, but it uses a bit more memory and time
    public int maxArea(int[] height) {
        int max = 0, l = 0, r = height.length - 1, top = 0;
        while (l < r) {
            // Compute max
            max = Math.max(max, Math.min(height[l], height[r]) * (r - l));
            // Attempt to find someone larger depending on the side
            if (height[l] < height[r]) for (top = height[l++]; l < r && height[l] <= top; l++);
            else for (top = height[r--]; r > l && height[r] <= top; r--);
        }
        return max;
    }
     */
}