package moveDuplicatesfromSortedArray;

import java.util.HashSet;
import java.util.Set;

public class MoveDuplicatesfromSortedArray {

	public int removeDuplicates(int[] nums) {

		Set<Integer> setArray = new HashSet<>();

		int trigger = 0;

		for (int i = 0; i < nums.length; i++) {
			if (!setArray.contains(nums[i])) {
				setArray.add(nums[i]);
				nums[trigger++] = nums[i];
			}
		}

		return trigger;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
