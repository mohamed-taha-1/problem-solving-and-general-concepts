package medium;

import java.util.HashSet;
import java.util.Set;

public class _3_LongestSubstringWithoutRepeatingCharacters {
	// Input: s = "abcabcbb"
	// Output: 3

	// Input: s = "bbbbb"
	// Output: 1

	// Input: s = "pwwkew"
	// Output: 3

	public static int lengthOfLongestSubstring(String s) {

		Set<Character> set = new HashSet<>();
		int max = 0;
		int left = 0; // Keep track of the starting index of the current substring
		for (int i = 0; i < s.length(); i++) {
			char findChar = s.charAt(i);
			while (set.contains(findChar)) {
				set.remove(s.charAt(left));
				left++;
			}

			set.add(findChar);
			max=Math.max(max, i-left+1);

		}

		return max;
	}

	public static void main(String[] args) {

		String s = "pwwkew";
		System.out.println(lengthOfLongestSubstring(s));

	}

}
