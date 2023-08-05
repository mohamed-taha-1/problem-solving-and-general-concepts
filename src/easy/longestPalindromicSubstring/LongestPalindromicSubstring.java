package longestPalindromicSubstring;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindromicSubstring {

	public static String longestPalindrome(String s) {

//		int max=0;
		int max2 = 0;
		String str = "";

		if ((s.length() == 1 || s.length() == 2) && !isPalindrome(s)) {

			str = s.substring(0, 1);

		} else if (isPalindrome(s)) {

			str = s;

		} else {
			Map<Character, Integer> mapped = new HashMap<>();

			for (int i = 0; i < s.length(); i++) {

				if (mapped.containsKey(s.charAt(i))  ) {
					System.out.println(mapped.get(s.charAt(i)) + " =>  and the i now => " + i);
					// max=Math.max(max,i- mapped.get(s.charAt(i)));
					max2 = Math.max(max2, s.substring(mapped.get(s.charAt(i)), i).length());

					System.out.println(" The max is : " + max2 + "   ::Is it plaindrome?     " + isPalindrome(str)
							+ "  :::::::  for the string  :  " + str);

					if (s.substring(mapped.get(s.charAt(i)), i).length() == max2) {

						if (i != s.length() && isPalindrome(s.substring(mapped.get(s.charAt(i)), i + 1))) {
							str = s.substring(mapped.get(s.charAt(i)), i + 1);
						}

					}

				}
				mapped.put(s.charAt(i), i);
			}
		}

		return str;

	}

	public static boolean isPalindrome(String s) {
		int left = 0;
		int right = s.length() - 1;

		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}

		return true;
	}

	public static void main(String[] args) {

		System.out.println(longestPalindrome("xaabacxcabaaxcabax"));
	}

}
