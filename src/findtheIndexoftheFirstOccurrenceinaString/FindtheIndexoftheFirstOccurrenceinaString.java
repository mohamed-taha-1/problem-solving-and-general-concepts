package findtheIndexoftheFirstOccurrenceinaString;

public class FindtheIndexoftheFirstOccurrenceinaString {
	public static int strStr(String haystack, String needle) {
		int firstOccurrenceIndex = -1; // Initialize with a default value

		for (int j = 0; j <= haystack.length() - needle.length(); j++) {
			if (haystack.substring(j, j + needle.length()).equals(needle)) {
				firstOccurrenceIndex = j; // Store the index of the first occurrence
				break; // Exit the loop after finding the first occurrence
			}
		}

		return firstOccurrenceIndex;
	}

	

	public static void main(String[] args) {
		String haystack = "leetcode", needle = "code";

		System.out.println(   strStr(haystack, needle)   );
		;

	}

}
