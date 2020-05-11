package Best_Time_To_Buy_And_Sell_Stocks_2;

import java.util.List;

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maxProfit(final List<Integer> A) {
        int n = A.size();
        if (n == 0) {return 0;}
        int profit = 0;
        for (int i = 1; i < n; i++){
            profit += Math.max(A.get(i) - A.get(i - 1), 0);
        }
        return profit;
    }
}

