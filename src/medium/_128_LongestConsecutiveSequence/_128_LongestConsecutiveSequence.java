package medium._128_LongestConsecutiveSequence;

import java.util.Arrays;

public class _128_LongestConsecutiveSequence {

	/*
	 * Given an unsorted array of integers nums, return the length of the longest
	 * consecutive elements sequence.
	 * 
	 * You must write an algorithm that runs in O(n) time.
	 * 
	 */
//
//			Example 1:
//
//			Input: nums = [100,4,200,1,3,2]
//			Output: 4
//			Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
//			Example 2:
//
//			Input: nums = [0,3,7,2,5,8,4,6,0,1]
//			Output: 9

	public static int longestConsecutive(int[] nums) {
		if (nums.length == 0)
			return 0;

		Arrays.sort(nums); // Sort the array

		int longestStreak = 1;
		int currentStreak = 1;

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[i - 1]) { // Check for duplicates
				if (nums[i] == nums[i - 1] + 1) {
					currentStreak++;
				} else {
					longestStreak = Math.max(longestStreak, currentStreak);
					currentStreak = 1;

				}

			}
		}

		return Math.max(longestStreak, currentStreak);
	}

	public static void main(String[] args) {
		int[] nums = { 9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6 };

		System.out.println(longestConsecutive(nums));

	}

}
