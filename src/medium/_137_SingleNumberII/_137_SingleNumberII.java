package medium._137_SingleNumberII;

public class _137_SingleNumberII {

//	Given an integer array nums where every element appears three times except for one, which appears exactly once.Find the single element and return it.
//	You must implement a solution with a linear runtime complexity and use only constant extra space.

	/*
	 * Input: nums = [2,2,3,2] Output: 3
	 * 
	 * Input: nums = [0,1,0,1,0,1,99] Output: 99
	 */

	public static int singleNumber(int[] nums) {

		int target = 0, tow = 0;
		for (int n : nums) {
			target = (target ^ n) & ~tow;
			tow = (tow ^ n) & ~target;

		}
		return target;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 2, 3, 2 };
		System.out.println(singleNumber(nums));

	}

}
