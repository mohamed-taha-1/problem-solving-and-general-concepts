package medium._438_FindAllAnagramsinaString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _438_FindAllAnagramsinaString {

	public static List<Integer> findAnagrams(String s, String p) {
		

		List<Integer> listAdd = new ArrayList<>();
		
		 // Check if either `s` or `p` is an empty string, return an empty result list
	    if (s == null || p == null || s.isEmpty() || p.isEmpty()) {
	        return listAdd;
	    }

		// Sort the characters of string `p`
		char[] pArray = p.toCharArray();
		Arrays.sort(pArray);
		String sortedP = new String(pArray);

		for (int i = 0; i <= s.length() - p.length(); i++) {
			
			int secondStringLength = p.length();
			
			String strLoop = s.substring(i, i + secondStringLength);
			char[] sArray = strLoop.toCharArray();
			Arrays.sort(sArray);
			String sortedS = new String(sArray);

			// Compare the sorted substrings to find anagrams
			if (sortedS.equals(sortedP)) {
				listAdd.add(i);
			}
		}

		return listAdd;
	}

	public static void main(String[] args) {
		String s = "abab", p = "ab";

		System.out.println("all first occuernase is:\t " + findAnagrams(s, p));

	}

}
