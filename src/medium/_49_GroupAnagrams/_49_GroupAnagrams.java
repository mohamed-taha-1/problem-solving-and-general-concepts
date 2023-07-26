package medium._49_GroupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _49_GroupAnagrams {

	public static List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> returnList = new ArrayList<>();
		Map<String, List<String>> map = new HashMap<>();

		for (String s1 : strs) {

			char[] arr1 = s1.toCharArray();
			Arrays.sort(arr1);
			String sorted = new String(arr1);

			if (!map.containsKey(sorted)) {
				map.put(sorted, new ArrayList<>());
			}

			map.get(sorted).add(s1);
		}

		returnList.addAll(map.values());

		return returnList;
	}

	public static void main(String[] args) {
		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };

		System.out.println(groupAnagrams(strs));
		;

	}

}
