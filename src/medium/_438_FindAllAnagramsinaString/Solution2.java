package medium._438_FindAllAnagramsinaString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2 {

	public static List<Integer> findAnagrams(String s, String p) {

		List<Integer> result = new ArrayList<>();

		// Check for edge cases
		if (s == null || p == null || s.length() < p.length()) {
			return result;
		}

		// Create a hash map to store the characters and their frequencies in string p
		Map<Character, Integer> charFrequencyMap = new HashMap<>();
		for (char c : p.toCharArray()) {
			charFrequencyMap.put(c, charFrequencyMap.getOrDefault(c, 0) + 1);
		}

		// Initialize the sliding window and the frequency map for the window
		int left = 0;
		int right = 0;
		int windowSize = p.length();

		Map<Character, Integer> windowFrequencyMap = new HashMap<>();

		while (right < s.length()) {
			// Expand the window to the right
			char rightChar = s.charAt(right);
			windowFrequencyMap.put(rightChar, windowFrequencyMap.getOrDefault(rightChar, 0) + 1);

			// Shrink the window from the left if the window size is equal to the length of
			// string p
			if (right - left + 1 == windowSize) {

				if (windowFrequencyMap.equals(charFrequencyMap)) {
					result.add(left);
				}

				char leftChar = s.charAt(left);
				windowFrequencyMap.put(leftChar, windowFrequencyMap.get(leftChar) - 1);

				if (windowFrequencyMap.get(leftChar) == 0) {
					windowFrequencyMap.remove(leftChar);
				}

				left++;
			}

			right++;
		}

		return result;

	}

	public static void main(String[] args) {
		String s = "abab", p = "ab";

		System.out.println("all first occuernase is:\t " + findAnagrams(s, p));

	}

}
