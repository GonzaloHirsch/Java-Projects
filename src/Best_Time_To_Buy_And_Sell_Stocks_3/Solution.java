package Best_Time_To_Buy_And_Sell_Stocks_3;

import java.util.List;

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maxProfit(final List<Integer> A) {
        if (A.size() == 0){return 0;}
        int firstBuy = Integer.MIN_VALUE;
        int secondBuy = Integer.MIN_VALUE;
        int firstSell = 0;
        int secondSell = 0;

        for (int price : A){
            firstBuy = Math.max(firstBuy, -price);
            firstSell = Math.max(firstSell, firstBuy + price);
            secondBuy = Math.max(secondBuy, firstSell-price);
            secondSell = Math.max(secondSell, secondBuy + price);
        }
        return secondSell;
    }
}
