package medium._34_FindFirstandLastPositionofElementinSortedArray;

import java.util.Arrays;

public class _34_FindFirstandLastPositionofElementinSortedArray {

	public static int[] searchRange(int[] nums, int target) {
	    int[] result = new int[] { -1, -1 };

	    int leftIndex = findFirstOccurrence(nums, target);
	    if (leftIndex != -1) {
	        int rightIndex = findLastOccurrence(nums, target);
	        result[0] = leftIndex;
	        result[1] = rightIndex;
	    }

	    return result;
	}

	private static int findFirstOccurrence(int[] nums, int target) {
	    int left = 0;
	    int right = nums.length - 1;
	    int index = -1;

	    while (left <= right) {
	        int mid = left + (right - left) / 2;

	        if (nums[mid] >= target) {
	            right = mid - 1;
	        } else {
	            left = mid + 1;
	        }

	        if (nums[mid] == target) {
	            index = mid;
	        }
	    }

	    return index;
	}

	private static int findLastOccurrence(int[] nums, int target) {
	    int left = 0;
	    int right = nums.length - 1;
	    int index = -1;

	    while (left <= right) {
	        int mid = left + (right - left) / 2;

	        if (nums[mid] <= target) {
	            left = mid + 1;
	        } else {
	            right = mid - 1;
	        }

	        if (nums[mid] == target) {
	            index = mid;
	        }
	    }

	    return index;
	}

	

	public static void main(String[] args) {
		// You must write an algorithm with O(log n) runtime complexity.

		int[] nums = { 5, 7, 7, 8, 8, 10 };
		int target = 6;

		System.out.println("the first and second occuernace of" + " this item in the binary searcha rray is" + ":"
				+ Arrays.toString(searchRange(nums, target)));

	}

}
