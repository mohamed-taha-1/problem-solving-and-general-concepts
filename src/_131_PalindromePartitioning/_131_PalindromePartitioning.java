package _131_PalindromePartitioning;

import java.util.ArrayList;
import java.util.List;

public class _131_PalindromePartitioning {

	/*
	 * Given a string s, partition s such that every substring of the partition is a
	 * palindrome . Return all possible palindrome partitioning of s.
	 */

	/*
	 * Input: s = "aab" Output: [["a","a","b"],["aa","b"]] Example 2:
	 */

	/*
	 * Input: s = "a" Output: [["a"]]
	 * 
	 */

	public static List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<>();
		List<String> current = new ArrayList<>();
		helper2(result, current, s, 0);

		return result;
	}

	private static void helper2(List<List<String>> result, List<String> current, String s, int start) {
		if (start == s.length()) {
			result.add(new ArrayList<>(current));
		}

		for (int i = start; i < s.length(); i++) {

			if (isPlandrom(start, i, s)) {
				current.add(s.substring(start, i + 1));
				helper2(result, current, s, i + 1);
				current.remove(current.size() - 1);
			}

		}

	}

	private static boolean isPlandrom(int start, int end, String s) {
		while (start < end) {
			if (s.charAt(start) != s.charAt(end))
				return false;

			start++;
			end--;
		}

		return true;
	}

	public static void main(String[] args) {
		String str = "aab";
		System.out.println(partition(str));

	}

}
