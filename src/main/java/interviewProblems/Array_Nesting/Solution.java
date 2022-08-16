package interviewProblems.Array_Nesting;

class Solution {
    public int arrayNesting(int[] nums) {
        int max = 0, index, count;
        // Mark visited with 0 and 1
        int[] visited = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            // Only check if it wasn't visited, otherwise the chain is the same
            if (visited[nums[i]] == 0) {
                index = i;
                count = 0;
                // Iterate while the number is not visited
                while (visited[nums[index]] == 0) {
                    visited[nums[index]] = 1;
                    index = nums[index];
                    count++;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}