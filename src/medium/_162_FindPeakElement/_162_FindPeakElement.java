package medium._162_FindPeakElement;

public class _162_FindPeakElement {

	// A peak element is an element that is strictly greater than its neighbors.

	/*
	 * Input: nums = [1,2,3,1] Output: 2 Explanation: 3 is a peak element and your
	 * function should return the index number 2.
	 */

	/*
	 * Input: nums = [1,2,1,3,5,6,4] Output: 5 Explanation: Your function can return
	 * either index number 1 where the peak element is 2, or index number 5 where
	 * the peak element is 6.
	 */

	// You must write an algorithm that runs in O(log n) time.

	public static int findPeakElement2(int[] nums) {

		int left = 0;
		int right = nums.length - 1;

		while (left < right) {
			int mid = left + (right - left) / 2;

			if (nums[mid] > nums[mid + 1]) {
				// If the element at mid is greater than the next element,
				// then there might be a peak on the left side (including mid).
				right = mid;
			} else {
				// If the element at mid is less than or equal to the next element,
				// then there might be a peak on the right side (excluding mid).
				left = mid + 1;
			}
		}

		// At the end of the loop, 'left' and 'right' will converge to the peak element.
		return right;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 1, 3, 5, 6, 4 };

		System.out.println(findPeakElement2(nums)); // index=5

	}

}
