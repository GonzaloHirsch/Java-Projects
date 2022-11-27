package interviewProblems.Best_Time_To_Buy_And_Sell_Stock_II;

class Solution {
    public int maxProfit(int[] prices) {
        int hold = 0, buy = -prices[0], sell = 0;
        for (int price : prices) {
            buy = Math.max(buy, hold - price);
            sell = Math.max(sell, buy + price);
            hold = Math.max(hold, sell);
        }
        return hold;
    }
}