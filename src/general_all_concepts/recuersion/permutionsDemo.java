package recuersion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class permutionsDemo {

	public static List<List<Integer>> getPermutioans(int[] nums) {

		List<List<Integer>> returnedResult = new ArrayList<>();
		List<Integer> currentCompined = new ArrayList<>();

		boolean[] used = new boolean[nums.length];

		helper(nums, used, currentCompined, returnedResult);

		return returnedResult;

	}

	private static void helper(int nums[], boolean[] used, List<Integer> currentCompined,
			List<List<Integer>> returnedResult) {
		if (currentCompined.size() == nums.length) {
			returnedResult.add(new ArrayList<>(currentCompined));
			return;
		}

		for (int i = 0; i < nums.length; i++) {

			if (!used[i]) {
				used[i] = true;
				currentCompined.add(nums[i]);
				helper(nums, used, currentCompined, returnedResult);
				currentCompined.remove(currentCompined.size() - 1);
				used[i] = false;

			}

		}

	}

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3 };

		List<List<Integer>> returnedResult = getPermutioans(arr);
		int counter = 1;

		for (List<Integer> permute : returnedResult) {
			System.out.println("The " + counter + " persmutaion for: " + Arrays.toString(arr) + " is  :" + permute);
			counter++;
		}

	}

}
