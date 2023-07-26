package medium._17_LetterCombinationsofaPhoneNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _17_LetterCombinationsofaPhoneNumber {

	public static List<String> letterCombinations(String digits) {
		if (digits.isEmpty()) {
			return new ArrayList<>(); // Return an empty list for empty input
		}

		HashMap<Character, String> digitMap = new HashMap<>();
		digitMap.put('2', "abc");
		digitMap.put('3', "def");
		digitMap.put('4', "ghi");
		digitMap.put('5', "jkl");
		digitMap.put('6', "mno");
		digitMap.put('7', "pqrs");
		digitMap.put('8', "tuv");
		digitMap.put('9', "wxyz");

		List<String> combinations = new ArrayList<>();
		generateCombinations(combinations, digits, digitMap, new StringBuilder(), 0);
		return combinations;
	}

	private static void generateCombinations(List<String> combinations, String digits,HashMap<Character, String> digitMap, StringBuilder sb, int index) {
		
		if (index == digits.length()) {
			combinations.add(sb.toString());
			return;
		}

		char currentDigit = digits.charAt(index);
		String currentDigitString = digitMap.get(currentDigit);
		
		for (int i = 0; i < currentDigitString.length(); i++) {
			char currentChar = currentDigitString.charAt(i);
			sb.append(currentChar);
			generateCombinations(combinations, digits, digitMap, sb, index + 1);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

	public static void main(String[] args) {
		System.out.println("Welcome taha go deep into the backtraking ");
					
		String str = "3";
		System.out.println(letterCombinations(str));

	}

}
