package _3_SumClosest;

import java.util.Arrays;

public class Solution2 {

	public static int threeSumClosest(int[] nums, int target) {
		int n = nums.length;
		int closestSum = Integer.MAX_VALUE;
		int minDiff = Integer.MAX_VALUE;

		Arrays.sort(nums);

		for (int i = 0; i < n - 2; i++) {
			int j = i + 1;
			int k = n - 1;

			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				int diff = Math.abs(target - sum);

				if (diff == 0) {
					return sum; // Found exact sum equal to target
				}

				if (diff < minDiff) {
					minDiff = diff;
					closestSum = sum;
				}

				if (sum < target) {
					j++; // Increment j to increase the sum
				} else {
					k--; // Decrement k to decrease the sum
				}
			}
		}

		return closestSum;
	}

	public static void main(String[] args) {

		int[] nums = { -1, 2, 1, -4 };
		int target = 1;

		System.out.println(threeSumClosest(nums, target));
	}

}
