package Subarray_Sum_Equals_K;

public class Solution {
    public int subarraySum(int[] nums, int k) {
        int sol = 0;
        int partial, j;
        for(int i = 0; i < nums.length; i++){
            partial = nums[i];
            if (partial == k){sol++;}
            j = i - 1;
            while (j >= 0){
                partial += nums[j--];
                if (partial == k){sol++;}
            }
        }
        return sol;
    }
}
