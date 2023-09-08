package medium._322_CoinChange;

import java.util.Arrays;

public class _322_CoinChange {

	// You are given an integer array coins representing coins of different
	// denominations and an integer amount representing a total amount of money.

	/*
	 * Return the fewest number of coins that you need to make up that amount. If
	 * that amount of money cannot be made up by any combination of the coins,
	 * return -1.
	 * 
	 */

	// coins = [1,2,5], amount = 11 ::3 => Explanation: 11 = 5 + 5 + 1

	// coins = [2], amount = 3 :: Output: -1

	// coins = [1], amount = 0 ::: 0

	public static int coinChange(int[] coins, int amount) {

		// Create an array to store the minimum number of coins needed for each amount
		// from 0 to 'amount'.
		int[] dp = new int[amount + 1];

		// Initialize the array with a value greater than 'amount' to indicate that
		// these amounts are not reachable initially.
		Arrays.fill(dp, amount + 1);

		// Base case: Zero coins are needed to make an amount of 0.
		dp[0] = 0;

		// Calculate the minimum number of coins needed for each amount from 1 to
		// 'amount'.
		for (int i = 1; i <= amount; i++) {
			for (int coin : coins) {
				// Check if the current coin can be used to make the amount 'i'.
				if (coin <= i) {
					// If so, calculate the minimum number of coins needed for the current amount.
					dp[i] = Math.min(dp[i], dp[i - coin] + 1);
				}
			}
		}

		// If dp[amount] is still greater than amount, it means the amount cannot be
		// formed with the given coins.
		// Return -1 in this case, otherwise return the minimum number of coins needed.
		return dp[amount] > amount ? -1 : dp[amount];
	}

	public static void main(String[] args) {

		int[] coins = { 1, 2, 5 };
		int amount = 11;
		System.out.println(coinChange(coins, amount));

	}

}
