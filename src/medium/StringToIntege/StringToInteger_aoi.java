package StringToIntege;

public class StringToInteger_aoi {

	public static int myAtoi(String s) {
		String str = s.trim();
		String[] arrOfStr = str.split("\\s+");
		int result = 0;

		for (String c : arrOfStr) {
			System.out.println(c);

			if (c.matches("-?\\d+")) {
				int sign = 1;
				int start = 0;

				if (c.charAt(0) == '-' || c.charAt(0) == '+') {
					if (c.charAt(0) == '-') {
						sign = -1;
					}
					start = 1;
				}

				for (int i = start; i < c.length(); i++) {
					int decimalValue = c.charAt(i) - '0';

					result = result * 10 + decimalValue;
				}

				return sign * result;
			}
		}
		return result;
	}

	public static int myAtoi2(String s) {
		String str = s.trim();
		int sign = 1;
		int result = 0;
		int i = 0;

		// Check for empty string
		if (str.isEmpty()) {
			return 0;
		}

		// Check for sign
		if (str.charAt(i) == '-' || str.charAt(i) == '+') {
			if (str.charAt(i) == '-') {
				sign = -1;
			}
			i++;
		}

		// Process the digits
		while (i < str.length() && Character.isDigit(str.charAt(i))) {
			int digit = str.charAt(i) - '0';

			// Handle overflow
			if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 7)) {
				return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
			result = result * 10 + digit;
			i++;
		}

		return sign * result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(myAtoi("words and 987"));

		// secon dway not use regex to get the values
		char c = '5'; // Example character
		int decimalValue = c - '0';
		System.out.println(decimalValue); // Output: 5

	}

}
