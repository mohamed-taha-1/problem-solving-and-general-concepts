package medium._90_SubsetsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _90_SubsetsII {

	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> cachedList = new ArrayList<>();
		Arrays.sort(nums);
		backtrak(result, cachedList, nums, 0);
		return result;

	}

	private static void backtrak(List<List<Integer>> result, List<Integer> cachedList, int[] nums, int start) {
		 result.add(new ArrayList<>(cachedList));

	        for (int i = start; i < nums.length; i++) {
	            if (i > start && nums[i] == nums[i - 1]) {
	                // Skip duplicates to avoid generating duplicate subsets
	                continue;
	            }
	            cachedList.add(nums[i]);
	            backtrak(result, cachedList, nums, i + 1);
	            cachedList.remove(cachedList.size() - 1);
	        }

	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 2 };

		System.out.println(subsetsWithDup(nums));

	}

}
