package addBinary;

public class AddBinary {

	public static String addBinary(String a, String b) {
		char[] a1 = a.toCharArray();
		char[] b1 = b.toCharArray();

		int max = Math.max(a1.length, b1.length);
		StringBuilder sb = new StringBuilder();
		int carry = 0;

		for (int i = 0; i < max; i++) {
			int firstAInt = (i < a1.length) ? Character.getNumericValue(a1[a1.length - 1 - i]) : 0;
			int secondAInt = (i < b1.length) ? Character.getNumericValue(b1[b1.length - 1 - i]) : 0;

			int sum = firstAInt + secondAInt + carry;
			
			sb.insert(0, sum % 2);
			carry = sum / 2;
			
			System.out.println("the sum is "+sum+" and the carry is "+carry  );
		}

		if (carry > 0) {
			sb.insert(0, carry);
			
		}

		return sb.toString();
	}

	public static void main(String[] args) {

		String a = "11";
		String b = "1";

		System.out.println(addBinary(a, b));

	}

}
