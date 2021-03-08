package interviewProblems.Jump_Game_2;

class Solution {
    public int jump(int[] nums) {
        int jumps = 0, n = nums.length, pos = 0, maxReach = 0, maxIndex = 0;

        while (pos < n - 1){
            // Reach from where I am
            if (pos + nums[pos] >= n - 1){
                pos += nums[pos];
            }
            // Only 1 jump option
            else if (nums[pos] == 1) {
                pos++;
            }
            // Many possible jumps
            else {
                maxReach = 0;
                for (int i = pos; i <= pos + nums[pos]; i++){
                    if (i - pos + nums[i] >= maxReach){
                        maxReach = i - pos + nums[i];
                        maxIndex = i;
                    }
                }
                pos = maxIndex;
            }

            jumps++;
        }

        return jumps;
    }
}