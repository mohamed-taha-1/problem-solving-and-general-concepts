package medium._238_ProductofArrayExceptSelf;

import java.util.Arrays;

public class ProductofArrayExceptSelf {

//	Input: nums = [1,2,3,4]   Output: [24,12,8,6]

	public static int[] productExceptSelf(int[] nums) {
		int product = 1;
		int[] result = new int[nums.length];

		for (int i = 0; i < nums.length; i++) {
			result[i] = 1;

		}
		for (int i = 0; i < nums.length; i++) {
			result[i] *= product;
			product *= nums[i];

		}

		int right = 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			result[i] *= right;
			right *= nums[i];

		}

		return result;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4 };
		System.out.println(Arrays.toString(productExceptSelf(nums)));
	}

}
