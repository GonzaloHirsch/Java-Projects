package interviewProblems.Best_Time_To_Buy_And_Sell_Stock_IV;

class Solution {
    public int maxProfit(int k, int[] prices) {
        // Array holds the k operations, with [buy, sell]
        int[][] ops = new int[k][2];
        // Fill the initial operation values
        for (int i = 0; i < ops.length; i++) ops[i][0] = Integer.MIN_VALUE;
        // Iterate all prices and find how each evolves
        for (int price : prices) {
            for (int i = 0; i < k; i++) {
                ops[i][0] = Math.max(ops[i][0], i == 0 ? -price : ops[i - 1][1] - price);
                ops[i][1] = Math.max(ops[i][1], ops[i][0] + price);
            }
        }
        return ops[ops.length - 1][1];
    }
}