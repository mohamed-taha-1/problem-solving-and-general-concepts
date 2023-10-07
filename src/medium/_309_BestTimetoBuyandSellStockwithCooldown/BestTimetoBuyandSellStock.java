package medium._309_BestTimetoBuyandSellStockwithCooldown;

public class BestTimetoBuyandSellStock {

	// Find the maximum profit you can achieve
	// After you sell your stock, you cannot buy stock on the next day (i.e.,
	// cooldown one day).
	// You may not engage in multiple transactions simultaneously (i.e., you must
	// sell the stock before you buy again).

	/*
	 * Input: prices = [1,2,3,0,2] Output: 3 Explanation: transactions = [buy, sell
	 * ,cooldown, buy, sell]
	 */

	/*
	 * Example 2: Input: prices = [1] Output: 0
	 */

//	 example 3: [1,2,4]  output=3 ; explaniation that you should choos the best time to sell l but thsi lead to an peek ; but if the max is not after it small
	public static int maxProfit(int[] prices) {
		if (prices.length <= 1)
			return 0;
		
		 int buy = Integer.MIN_VALUE; // The maximum profit when holding a stock (buying)
		    int sell = 0; // The maximum profit when not holding a stock (selling)
		    int cooldown = 0; // The maximum profit when in cooldown

		    for (int price : prices) {
		        int prevBuy = buy;
		        buy = Math.max(buy, cooldown - price); // Buy or do nothing
		        cooldown = sell; // Cooldown after selling
		        sell = Math.max(sell, prevBuy + price); // Sell or do nothing
		    }

		    return Math.max(sell, cooldown); // The answer is the maximum of sell and cooldown

	}

	public static void main(String[] args) {
		int[] prices = { 1,2,4 };
		System.out.println(maxProfit(prices));

	}

}
