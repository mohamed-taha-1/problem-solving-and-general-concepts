package easy._169_MajorityElement;

public class _169_MajorityElement {

//	Given an array nums of size n, return the majority element.
//	The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

	/*
	 * Input: nums = [3,2,3] Output: 3
	 */

	public static int majorityElement(int[] nums) {

		int candidate = nums[0];
		int count = 1;

		// Find a candidate majority element
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == candidate) {
				count++;
			} else {
				count--;
				if (count == 0) {
					candidate = nums[i];
					count = 1;
				}
			}
		}

		// Verify if the candidate is the majority element
		count = 0;
		for (int num : nums) {
			if (num == candidate) {
				count++;
			}
		}

		if (count > nums.length / 2) {
			return candidate;
		}

		return -1; // No majority element found
	}

	public static void main(String[] args) {
		int[] nums = { 3, 2, 3 };

		System.out.println(majorityElement(nums));

	}

}
