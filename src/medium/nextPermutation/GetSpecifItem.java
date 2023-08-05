package nextPermutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class GetSpecifItem {

public static void nextPermutation(int[] nums) {
		
	if (nums.length <= 1)
		System.out.println(new ArrayList<>(Arrays.asList(nums)));

	List<List<Integer>> finalList = new ArrayList<>();

	for (int i = 0; i < nums.length; i++) {

		List<Integer> loop = new ArrayList<>();
		int trigger = nums[i];
		loop.add(trigger);

		for (int j = 0; j < nums.length; j++) {

			if (i == j)
				continue;

			loop.add(nums[j]);

		}

		finalList.add(loop);

	}

	// now reverse the order also to get all permuitations

	for (int i = nums.length - 1; i >= 0; i--) {

		List<Integer> loop = new ArrayList<>();
		int trigger = nums[i];
		loop.add(trigger);

		for (int j = nums.length - 1; j >= 0; j--) {

			if (i == j)
				continue;

			loop.add(nums[j]);

		}

		finalList.add(loop);

	}

	// remove duplicates from final result
	Set<List<Integer>> setOfLists = new HashSet<>(finalList);
	finalList.clear();
	finalList.addAll(setOfLists);

	System.out.println("All permutaions are : " + finalList.toString());

	// now group based on keys/items of arrays and return back all permutation for
	// specific item.

	Map<Integer, List<List<Integer>>> groupedMap = new HashMap<>();

	for (List<Integer> list : finalList) {
		int key = list.get(0);
		if (!groupedMap.containsKey(key)) {
			groupedMap.put(key, new ArrayList<>());
		}
		groupedMap.get(key).add(list);
	}

	System.out.println("\n after grouping  " + groupedMap.entrySet());

	List<List<Integer>> sortedList = finalList.stream().sorted(Comparator.comparing(list -> list.get(0))).toList();

	System.out.println("\n after sorted \t" + sortedList.get(0));
					 
					
	}

	public static void main(String[] args) {

		int[] nums = {3,2,1};
		nextPermutation(nums);

	}

}
