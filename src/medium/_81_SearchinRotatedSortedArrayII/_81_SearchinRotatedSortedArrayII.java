package medium._81_SearchinRotatedSortedArrayII;

public class _81_SearchinRotatedSortedArrayII {

	public static boolean search(int[] nums, int target) {

		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			// If the middle element is equal to the target, return true
			if (nums[mid] == target) {
				return true;
			}

			// If we have duplicates at both ends, we can't decide which half to discard
			// In this case, we move the pointers inwards and repeat the search
			while (left < mid && nums[left] == nums[mid]) {
				left++;
			}
			while (mid < right && nums[mid] == nums[right]) {
				right--;
			}

			// Check if the left half is sorted
			if (nums[left] <= nums[mid]) {
				if (nums[left] <= target && target < nums[mid]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
			// Check if the right half is sorted
			else {
				if (nums[mid] < target && target <= nums[right]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
		}

		return false;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 5, 6, 0, 0, 1, 2 };
		int target = 0;
		System.out.println(search(nums, target)); // Output: true

	}

}
