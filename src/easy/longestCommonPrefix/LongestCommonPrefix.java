package longestCommonPrefix;

public class LongestCommonPrefix {

	public static String longestCommonPrefix(String[] strs) {

		if (strs == null || strs.length == 0) {
			System.out.println("No common prefix");
			return "";
		}

		String prefix = strs[0];
		int max = prefix.length();

		for (int i = 1; i < strs.length; i++) {
			int j;
			for (j = 0; j < prefix.length() && j < strs[i].length(); j++) {
					if (prefix.charAt(j) != strs[i].charAt(j)) {
						break;
					}
			}
			max = j;
			prefix = prefix.substring(0, max);
		}

		return prefix;

	}

	public static void main(String[] args) {

		String[] arr = { "flower", "flow", "flight" };
		longestCommonPrefix(arr);
	}
}
