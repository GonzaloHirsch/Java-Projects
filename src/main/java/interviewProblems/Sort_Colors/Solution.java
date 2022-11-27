package interviewProblems.Sort_Colors;

class Solution {
    public void sortColors(int[] nums) {
        // Count instances of the color
        int[] counts = new int[3];
        for (int color : nums) counts[color]++;

        for (int i = 0, currentColor = 0; i < nums.length; i++) {
            while (counts[currentColor] == 0) currentColor++;
            nums[i] = currentColor;
            counts[currentColor]--;
        }
    }
}