package interviewProblems.Daily_Temperatures;

/* NOTE: It can be more optimized by using a stack, which has a similar logic to mine */
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ref = new int[100 - 30 + 1];
        int[] res = new int[temperatures.length];

        // Add the ref to the last temp
        ref[temperatures[temperatures.length - 1] - 30] = temperatures.length - 1;
        for (int i = temperatures.length - 2; i >= 0; i--) {
            // Store smallest index for that temperature, always will be decreasing
            ref[temperatures[i] - 30] = i;
            // Compare with the next one
            if (temperatures[i] == temperatures[i + 1]) res[i] = res[i + 1] > 0 ? res[i + 1] + 1 : 0;
            else if (temperatures[i] < temperatures[i + 1]) res[i] = 1;
                // Current temp is larger than the previous one
            else {
                int min = 10000000;
                for (int t = temperatures[i] + 1; t <= 100; t++) {
                    if (ref[t - 30] > 0) min = Math.min(ref[t - 30], min);
                }
                res[i] = min == 10000000 ? 0 : min - i;
            }
        }
        return res;
    }
}

