package main.medium;

@SuppressWarnings("unused")
public class BestTimeToSellAndBuyStock {
    public int maxProfit(int[] prices) {
        int hold = -prices[0];
        int unhold = 0;

        for (int i = 1; i < prices.length; i++)
        {
            hold = Math.max(hold, -prices[i]);
            unhold = Math.max(hold + prices[i], unhold);
        }

        return unhold;
    }
}
