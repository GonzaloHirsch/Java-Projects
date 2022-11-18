package interviewProblems.Best_Time_To_Buy_And_Sell_Stock_With_Cooldown;

class Solution {
    public int maxProfit(int[] prices) {
        int sell = 0, buy = -prices[0], hold = 0, tmp;
        for (int price : prices) {
            tmp = sell;
            // Sell state is being holding a stock and having sold it just now at this price
            sell = buy + price;
            // Buy state is the maximum of the previous state (aka not buying) and holding/resting then buying
            buy = Math.max(buy, hold - price);
            // Holding state is the maximum between having sold or being already holding
            hold = Math.max(hold, tmp);
        }
        return Math.max(hold, sell);
    }
}