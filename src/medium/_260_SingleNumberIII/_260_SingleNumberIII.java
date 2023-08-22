package medium._260_SingleNumberIII;

import java.util.Arrays;

public class _260_SingleNumberIII {

	public static int[] singleNumber(int[] nums) {
		int xorResult = 0;

		// XOR all the numbers in the array
		for (int num : nums) {
			xorResult ^= num;
		}

//		int rightmostSetBit = 1;
//		if ((xorResult & rightmostSetBit) == 0) {
//			rightmostSetBit <<= 1;
//		}
		
		 int rightmostSetBit = xorResult & -xorResult;

		int num1 = 0;
		int num2 = 0;

		// Divide the numbers into two groups based on the rightmost set bit
		for (int num : nums) {
			if ((num & rightmostSetBit) != 0) {
				num1 ^= num;
			} else {
				num2 ^= num;
			}
		}
		return new int[] { num1, num2 };
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 1, 3, 2, 5 };

		System.out.println(Arrays.toString(singleNumber(nums)));
	}

}
