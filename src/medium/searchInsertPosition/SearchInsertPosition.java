package searchInsertPosition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SearchInsertPosition {

	public static int searchInsert(Integer[] array, int target) {
		List<Integer> arrayList = new ArrayList<>(Arrays.asList(array));

		for (int i = 0; i < arrayList.size(); i++) {
			if (target == arrayList.get(i)) {
				return i;
			} else if (target < arrayList.get(i)) {
				arrayList.add(i, target);
				Integer[] newArray = arrayList.toArray(new Integer[arrayList.size()]);
				return searchInsert(newArray, target);
			}
		}

		arrayList.add(target);
		Integer[] newArray = arrayList.toArray(new Integer[arrayList.size()]);
		return searchInsert(newArray, target);
	}

	public static void main(String[] args) {

		Integer[] nums = { 1, 3, 5, 6 };
		int target = 8;
		System.out.println(searchInsert(nums, target));
	}
}
