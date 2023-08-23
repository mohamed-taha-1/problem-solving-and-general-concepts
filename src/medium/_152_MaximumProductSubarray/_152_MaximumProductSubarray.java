package medium._152_MaximumProductSubarray;

public class _152_MaximumProductSubarray {

	/*
	 * Input: nums = [2,3,-2,4] Output: 6 Explanation: [2,3] has the largest product
	 * 6.
	 */

	/*
	 * Input: nums = [-2,0,-1] Output: 0 Explanation: The result cannot be 2,
	 * because [-2,-1] is not a subarray.
	 */

	public static int maxProduct(int[] nums) {

		if (nums == null || nums.length == 0) {
			return 0;
		}

		int maxProduct = nums[0];
		int minProduct = nums[0];
		int result = nums[0];

		for (int i = 1; i < nums.length; i++) {
			int num = nums[i];

			// Update maxProduct and minProduct considering the current number
			if (num < 0) {
				int temp = maxProduct;
				maxProduct = minProduct;
				minProduct = temp;
			}
			maxProduct = Math.max(num, maxProduct * num);
			minProduct = Math.min(num, minProduct * num);

			// Update the global result
			result = Math.max(result, maxProduct);
		}

		return result;
	}

	public static void main(String[] args) {
		int[] nums = { -2, 0, -1 };
		System.out.println(maxProduct(nums));

	}

}
