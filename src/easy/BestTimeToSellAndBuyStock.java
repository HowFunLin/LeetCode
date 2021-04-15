package easy;

public class BestTimeToSellAndBuyStock
{
	public int maxProfit(int[] prices) {
		int[][] dp = new int[prices.length][2];
		dp[0][0] = 0; // no stock
		dp[0][1] = -prices[0]; // hold stock
		
		for(int i = 1; i < prices.length; i++)
		{
			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
			dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
		}
		
		return dp[prices.length - 1][0];
    }
}

class SaveTime extends BestTimeToSellAndBuyStock
{
	@Override
	public int maxProfit(int[] prices)
	{
		int no = 0;
		int hold = -prices[0];
		
		for(int i = 0; i < prices.length; i++)
		{
			no = Math.max(no, hold + prices[i]);
			hold = Math.max(hold, -prices[i]);
		}
		
		return no;
	}
}