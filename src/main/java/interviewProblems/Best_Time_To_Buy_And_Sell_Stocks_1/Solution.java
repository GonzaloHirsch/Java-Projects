package interviewProblems.Best_Time_To_Buy_And_Sell_Stocks_1;

import java.util.List;

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maxProfit(final List<Integer> A) {
        int n = A.size();
        if (n == 0){return 0;}
        int minNow = A.get(0);
        int max = 0;
        for (int i = 1; i < n; i++){
            minNow = Math.min(A.get(i), minNow);
            max = Math.max(max, A.get(i) - minNow);
        }
        return max;
    }
}
