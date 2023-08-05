package plusOne;

public class PlusOne {

	public static int[] plusOne(int[] digits) {
		int totalSum = 0;
		int n = digits.length;
		 // Check if the most significant digit is 9
	    if (digits[n - 1] == 9 ) {
	    	 digits[n - 1] = 0;
	    }

		for (int i = 0; i < digits.length; i++) {
			totalSum = digits[i] + totalSum * 10;
		}

		totalSum = totalSum + 1;
		String numberString = String.valueOf(totalSum);
		int[] returned = new int[numberString.length()];

		for (int i = 0; i < numberString.length(); i++) {
			returned[i] = Character.getNumericValue(numberString.charAt(i));
		}

		return returned;
	}

	public static void main(String[] args) {

		int[] paramtetArray = {9,8,7,6,5,4,3,2,1,0 };
		System.out.println(plusOne(paramtetArray)[4]);

	}

}
