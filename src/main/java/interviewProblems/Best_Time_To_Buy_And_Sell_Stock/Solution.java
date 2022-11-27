package interviewProblems.Best_Time_To_Buy_And_Sell_Stock;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int maxProfit(int[] prices) {
        int buy = -prices[0], sell = 0;
        for (int price : prices) {
            // Selling is the act of selling the stock kept as buy
            sell = Math.max(sell, buy + price);
            // The buying state is the maximum between keeping the stock or buying a new one
            // No need to use the hold because it's always 0 - price
            buy = Math.max(buy, -price);
        }

        // In case no profit was made
        return Math.max(0, sell);
    }
}