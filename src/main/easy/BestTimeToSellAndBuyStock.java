package main.easy;

public class BestTimeToSellAndBuyStock
{
	public int maxProfit(int[] prices) {
//		// 二维 DP
//		int[][] dp = new int[prices.length][2];
//		dp[0][0] = 0; // no stock
//		dp[0][1] = -prices[0]; // hold stock
//
//		for(int i = 1; i < prices.length; i++)
//		{
//			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
//			dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
//		}
//
//		return dp[prices.length - 1][0];

		int no = 0;
		int hold = -prices[0];

		for (int price : prices) {
			no = Math.max(no, hold + price);
			hold = Math.max(hold, -price);
		}

		return no;
    }
}