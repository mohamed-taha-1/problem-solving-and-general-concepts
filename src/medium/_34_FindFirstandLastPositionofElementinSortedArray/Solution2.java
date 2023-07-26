package medium._34_FindFirstandLastPositionofElementinSortedArray;

import java.util.Arrays;

public class Solution2 {

	public static int[] searchRange(int[] nums, int target) {
		int[] result = new int[] { -1, -1 };
		searchRangeHelper(nums, target, result, 0, nums.length - 1);
		return result;
	}

	private static void searchRangeHelper(int[] nums, int target, int[] result, int left, int right) {
		if (left > right) {
			return;
		}

		int mid = left + (right - left) / 2;

		if (nums[mid] == target) {
			if (result[0] == -1 || mid < result[0]) {
				result[0] = mid; // Update leftmost occurrence
			}
			if (result[1] == -1 || mid > result[1]) {
				result[1] = mid; // Update rightmost occurrence
			}
		}

		if (nums[mid] >= target) {
			searchRangeHelper(nums, target, result, left, mid - 1);
		}

		if (nums[mid] <= target) {
			searchRangeHelper(nums, target, result, mid + 1, right);
		}
	}

	public static void main(String[] args) {
		// binary search with recuersion

		int[] nums = { 5, 7, 7, 8, 8, 10 };
		int target = 6;

		System.out.println("the first and second occuernace of" + " this item in the binary searcha rray is" + ":"
				+ Arrays.toString(searchRange(nums, target)));

	}

}
