package medium._33_SearchinRotatedSortedArray;

public class Solution2 {

	public static int search(int[] nums, int target) {
		return binarySearch(nums, target, 0, nums.length - 1);
	}

	private static int binarySearch(int[] nums, int target, int left, int right) {
		if (left > right) {
			return -1;
		}

		int mid = left + (right - left) / 2;

		if (nums[mid] == target) {
			return mid; // Found the target element
		}

		// Check which part is sorted and continue the search on the appropriate side
		if (nums[left] <= nums[mid]) {
			if (target >= nums[left] && target < nums[mid]) {
				return binarySearch(nums, target, left, mid - 1);
			} else {
				return binarySearch(nums, target, mid + 1, right);
			}
		} else {
			if (target > nums[mid] && target <= nums[right]) {
				return binarySearch(nums, target, mid + 1, right);
			} else {
				return binarySearch(nums, target, left, mid - 1);
			}

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
		int target = 3;

		System.out.println(search(nums, target));
	}

}
