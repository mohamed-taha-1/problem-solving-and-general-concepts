package recuersion;

import java.util.ArrayList;
import java.util.List;

public class PermutationinString {

	public static List<String> permute(String str) {

		List<String> returnList = new ArrayList<>();
		StringBuilder current = new StringBuilder();

		char[] arr2 = str.toCharArray();

		helper(returnList, current, arr2, new boolean[arr2.length], 0);

		return returnList;

	}

	private static void helper(List<String> retunrList, StringBuilder current, char[] arr, boolean[] used, int index) {
		if (index == arr.length) {
			retunrList.add(current.toString());
		} else {

			for (int i = 0; i < arr.length; i++) {
				if (!used[i]) {
					used[i] = true;

					current.append(arr[i]);
					helper(retunrList, current, arr, used, index + 1);
					current.deleteCharAt(current.length() - 1);
					used[i] = false;

				}

			}
		}

	}

	public static boolean PernuteString(String s1, String s2) {

		List<String> listOfStrings = permute(s1);
		for (String s : listOfStrings) {
			if (s2.contains(s))
				return true;

		}

		return false;
	}

	public static void main(String[] args) {
		System.out.println("permution in string \n");

		String s1 = "ab";
		String s2 = "eidbaooo";

		System.out.println("the list are:" + PernuteString(s1, s2));

	}

}
