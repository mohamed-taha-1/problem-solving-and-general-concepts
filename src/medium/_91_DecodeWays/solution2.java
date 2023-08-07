package medium._91_DecodeWays;

import java.util.ArrayList;
import java.util.List;

public class solution2 {
	public static int numDecodings(String s) {
		int n = s.length();
		int[] dp = new int[n + 1];

		// Base case: empty string has one decoding (an empty string)
		dp[n] = 1;

		// For the last character, set the number of decodings based on whether it's '0'
		// or not
		dp[n - 1] = s.charAt(n - 1) == '0' ? 0 : 1;

		// Build the solution for the rest of the string
		for (int i = n - 2; i >= 0; i--) {
			if (s.charAt(i) == '0') {
				// Skip leading zeros (e.g., "06")
				continue;
			}

			int currentNumber = Integer.parseInt(s.substring(i, i + 2));

			if (currentNumber <= 26) {
				// If current two digits form a valid encoding, we have two options:
				// 1. Consider this two-digit as one decoding and move two steps ahead (i+2).
				// 2. Ignore this two-digit and move one step ahead (i+1).
				dp[i] = dp[i + 1] + dp[i + 2];
			} else {
				// If the current two-digit is not a valid encoding, we only have one option
				// to ignore this two-digit and move one step ahead (i+1).
				dp[i] = dp[i + 1];
			}
		}

		return dp[0];
	}

	public static void main(String[] args) {
		String s = "06";

		System.out.println(numDecodings(s));

	}

}
