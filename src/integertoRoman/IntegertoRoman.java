package integertoRoman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IntegertoRoman {

	public static String intToRoman(int num) {

		int temp = 0;
		List<Integer> list = new ArrayList<>();

		String resultString = "";

		while (num > 0) {
			temp = num % 10;
			list.add(temp);
			num = num / 10;
		}

		for (int i = 0; i < list.size(); i++) {
			int element = list.get(i);
			int multipliedValue = element * (int) Math.pow(10, i);
			list.set(i, multipliedValue);
		}

		for (int i = 0; i < list.size(); i++) {
			int element = list.get(i);
			System.out.println(element);

			if (element == 9) {
				resultString += "IX";
			} else if (element >= 5) {
				resultString += "V";
				element -= 5;
				while (element > 0) {
					resultString += "I";
					element--;
				}
			} else if (element == 4) {
				resultString += "IV";
			} else {
				while (element > 0) {
					resultString += "I";
					element--;
				}
			}

			if (element == 90) {
				resultString += "XC";
			} else if (element >= 50) {
				resultString += "L";
				element -= 50;
				while (element >= 10) {
					resultString += "X";
					element -= 10;
				}
			} else if (element == 40) {
				resultString += "XL";
			} else {
				while (element >= 10) {
					resultString += "X";
					element -= 10;
				}
			}

			if (element == 900) {
				resultString += "CM";
			} else if (element >= 500) {
				resultString += "D";
				element -= 500;
				while (element >= 100) {
					resultString += "C";
					element -= 100;
				}
			} else if (element == 400) {
				resultString += "CD";
			} else {
				while (element >= 100) {
					resultString += "C";
					element -= 100;
				}
			}

			if (element >= 1000) {
				while (element >= 1000) {
					resultString += "M";
					element -= 1000;
				}
			}
		}

		String reversed = reverseString(resultString);
		return reversed;
	}

	public static String reverseString(String input) {
		StringBuilder stringBuilder = new StringBuilder(input);
		stringBuilder.reverse();
		return stringBuilder.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num = 1994;
		String s = intToRoman(num);

		System.out.println("The return Roman for this Integer is:    " + s);

	}

}
