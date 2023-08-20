package medium._139_WordBreak;

import java.util.Arrays;
import java.util.List;

public class _139_WordBreak {

	/*
	 * Given a string s and a dictionary of strings wordDict, return true if s can
	 * be segmented into a space-separated sequence of one or more dictionary words.
	 * 
	 */

	// Note that the same word in the dictionary may be reused multiple times in the
	// segmentation.

	/*
	 * Input: s = "leetcode", wordDict = ["leet","code"] Output: true Explanation:
	 * Return true because "leetcode" can be segmented as "leet code".
	 */

	/*
	 * Input: s = "applepenapple", wordDict = ["apple","pen"] Output: true
	 * Explanation: Return true because "applepenapple" can be segmented as
	 * "apple pen apple". Note that you are allowed to reuse a dictionary word.
	 */

	/*
	 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"] Output:
	 * false
	 */
	public static boolean wordBreak(String s, List<String> wordDict) {

		String result = s;
		for (int i = 0; i < wordDict.size(); i++) {

			if (s.contains(wordDict.get(i))) {
				result = result.replace(wordDict.get(i), "");
			}

			if (result.length() == 0 && i == wordDict.size() - 1)
				return true;
		}

		return false;
	}

	public static boolean wordBreak2(String s, List<String> wordDict) {
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;

		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (dp[j] && wordDict.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}

		}
		return dp[s.length()];
	}

	public static void main(String[] args) {
		List<String> list = Arrays.asList("cats", "dog", "sand", "and", "cat");
		String s = "catsandog";
		System.out.println(wordBreak2(s, list));

	}

}
