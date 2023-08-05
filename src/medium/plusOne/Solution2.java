package plusOne;

public class Solution2 {

	public static int[] plusOne(int[] digits) {
		int n = digits.length;

		// Check if all digits are at their maximum value
		boolean allNines = true;
		for (int digit : digits) {
			if (digit != 9) {
				allNines = false;
				break;
			}
		}

		if (allNines) {
			int[] result = new int[n + 1];
			result[0] = 1;
			return result;
		}

		// Handle normal incrementation
		int carry = 1;
		for (int i = n - 1; i >= 0; i--) {
			
			int sum = digits[i] + carry;
			
			digits[i] = sum % 10;
			carry = sum / 10;

			if (carry == 0) {
				break;
			}
		}

		return digits;
	}

	public static void main(String[] args) {

		int[] paramtetArray = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		System.out.println(plusOne(paramtetArray)[0]);

	}

}
