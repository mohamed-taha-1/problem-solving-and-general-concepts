package integertoRoman;

public class solution2 {

	public static String intToRoman(int num) {

		StringBuilder sb = new StringBuilder();

		while (num >= 1000) {
			sb.append("M");
			num -= 1000;
		}

		if (num >= 900) {
			sb.append("CM");
			num -= 900;
		} else if (num >= 500) {
			sb.append("D");
			num -= 500;
		} else if (num >= 400) {
			sb.append("CD");
			num -= 400;
		}

		while (num >= 100) {
			sb.append("C");
			num -= 100;
		}

		if (num >= 90) {
			sb.append("XC");
			num -= 90;
		} else if (num >= 50) {
			sb.append("L");
			num -= 50;
		} else if (num >= 40) {
			sb.append("XL");
			num -= 40;
		}

		while (num >= 10) {
			sb.append("X");
			num -= 10;
		}

		if (num >= 9) {
			sb.append("IX");
			num -= 9;
		} else if (num >= 5) {
			sb.append("V");
			num -= 5;
		} else if (num >= 4) {
			sb.append("IV");
			num -= 4;
		}

		while (num > 0) {
			sb.append("I");
			num--;
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(intToRoman(1999)); 

	}

}
