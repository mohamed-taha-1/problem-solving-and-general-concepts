package easy._242_ValidAnagram;

import java.util.Arrays;

public class _242_ValidAnagram {

	/*
	 * An Anagram is a word or phrase formed by rearranging the letters of a
	 * different word or phrase, typically using all the original letters exactly
	 * once.
	 */

	public static boolean isAnagram(String s, String t) {

		// Remove spaces and convert both strings to lowercase
		char[] sChars = s.strip().trim().toCharArray();
	    char[] tChars = t.strip().trim().toCharArray();
	    Arrays.sort(sChars);
	    Arrays.sort(tChars);

	    return Arrays.equals(sChars, tChars);
	}

	public static void main(String[] args) {
		String s = "rat", t = "car";
		System.out.println(isAnagram(s, t));

	}

}
