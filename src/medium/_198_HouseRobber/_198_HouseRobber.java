package medium._198_HouseRobber;

public class _198_HouseRobber {

	// 19K dynamic programming
	/*
	 * You are a professional robber planning to rob houses along a street. Each
	 * house has a certain amount of money stashed, the only constraint stopping you
	 * from robbing each of them is that adjacent houses have security systems
	 * connected and it will automatically contact the police if two adjacent houses
	 * were broken into on the same night.
	 */

	/*
	 * Given an integer array nums representing the amount of money of each house,
	 * return the maximum amount of money you can rob tonight without alerting the
	 * police.
	 */

	// automatically contact the police if two adjacent houses were broken into on
	// the same night.

	public static int rob(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int n = nums.length;
		if (n == 1) {
			return nums[0];
		}

		int prev1 = nums[0];
		int max = Math.max(nums[0], nums[1]);

		for (int i = 2; i < n; i++) {
			int current = Math.max(max, prev1 + nums[i]);
			prev1 = max;
			max = current;
		}

		return max;
	}

	public static int rob2(int[] nums) {

		int maxRobbery = 0;

		for (int i = 0; i < nums.length; i++) {
			int temp = 0;
			int max = 0;

			for (int j = i + 2; j < nums.length; j++) {
				max = Math.max(max, nums[j]);
			}

			for (int j = i + 2; j < nums.length; j++) {
				if (nums[j] == max) {
					if (j + 2 < nums.length) {
						if (nums[j + 2] >= 0) {
							temp += max + nums[j + 2];
						} else {
							temp += max;
						}
					} else {
						temp += max;
					}
				}
			}

			maxRobbery = Math.max(maxRobbery, nums[i] + temp);
		}

		return maxRobbery;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 1 };
		System.out.println(rob(nums));

	}

}
