package medium._91_DecodeWays;

import java.util.ArrayList;
import java.util.List;

public class _91_DecodeWays {

	public static int numDecodings(String s) {
		char[] arr = s.toCharArray();
		List<String> listStr = new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {
			StringBuilder sb = new StringBuilder();

			if (arr[i] == '1') {
				if (i + 1 < arr.length && arr[i + 1] != '0') {
					sb.append('A');
				} else if (i + 1 < arr.length && arr[i + 1] == '0') {
					sb.append('J'); // Assuming 'J' is the corresponding character for "10"
					i++; // Skip the next character '0'
				}
			} else if (arr[i] == '0') {
				// Handle cases when the character at index i is '0'
				// For example, '20' should be decoded as "T"
				if (i + 1 < arr.length && arr[i + 1] != '0') {
					int targetAsciiValue = 'a' + Character.getNumericValue(arr[i + 1]);
					char targetCharacter = (char) targetAsciiValue;
					sb.append(targetCharacter);
				}
				i++; // Skip the next character '0'
			} else {
				int targetAsciiValue = 'a' + Character.getNumericValue(arr[i]);
				char targetCharacter = (char) targetAsciiValue;
				sb.append(targetCharacter);
			}

			listStr.add(sb.toString());
		}

		return listStr.size();

	}

	public static void main(String[] args) {
		String s = "06";

		System.out.println(numDecodings(s));

	}

}
