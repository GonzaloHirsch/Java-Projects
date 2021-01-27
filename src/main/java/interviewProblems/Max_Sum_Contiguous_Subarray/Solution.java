package interviewProblems.Max_Sum_Contiguous_Subarray;

import java.util.List;

public class Solution {
    public int maxSubArray(final List<Integer> A) {
        int n = A.size();
        int max = A.get(0);
        int partial = 0;
        int subpartial = 0;
        int i = 0;
        boolean counting = false;
        while (i < n){
            if (A.get(i) > 0){
                if (partial + subpartial < 0){
                    partial = A.get(i);
                } else {
                    partial += subpartial + A.get(i);
                }
                if (partial > max){
                    max = partial;
                }
                subpartial = 0;
            } else {
                subpartial += A.get(i);
                if (A.get(i) > max){
                    max = A.get(i);
                }
            }
            i++;
        }

        return max;
    }
}
