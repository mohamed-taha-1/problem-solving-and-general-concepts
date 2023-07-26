package medium._47_PermutationsII;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _47_PermutationsII {

	public static List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> returnList = new ArrayList<>();
		List<Integer> permuted = new ArrayList<>();

		helper(returnList, permuted, nums, new boolean[nums.length], 0);

	  Set<List<Integer>> set= new HashSet<>(returnList);
	  returnList.clear();
	  returnList.addAll(set);
		return  returnList;
	}

	private static void helper(List<List<Integer>> returnList, List<Integer> permuted, int[] nums, boolean[] used,
			int start) {

		if (permuted.size() == nums.length) {
			returnList.add(new ArrayList<>(permuted));
			return;
		} else {

			for (int i = 0; i < nums.length; i++) {

				if (!used[i]) {
					used[i] = true;
					permuted.add(nums[i]);
					helper(returnList, permuted, nums, used, i);
					permuted.remove(permuted.size() - 1);
					used[i] = false;

				}

			}

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums= {1,1,2};
		
		System.out.println(permuteUnique(nums));

	}

}
