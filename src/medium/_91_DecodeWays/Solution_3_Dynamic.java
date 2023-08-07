package medium._91_DecodeWays;

public class Solution_3_Dynamic {

	public static int numDecodings(String s) {
		int n = s.length();
		int[] db = new int[n + 1];

		// bottom-up approach

		db[n] = 1;
		db[n - 1] = s.charAt(n - 1) == '0' ? 0 : 1;

		for (int i = n - 2; i >= 0; i--) {

			if (s.charAt(i) == '0') {
				// Skip leading zeros (e.g., "06")
				continue;
			}

			String Newstr = s.substring(i, i + 2);

			int targetNumbers = Integer.parseInt(Newstr);

			if (targetNumbers <= 26) {

				db[i] = db[i + 1] + db[i + 2];

			} else {
				db[i] = db[i + 1];
			}

		}

		return db[0];
	}

	public static void main(String[] args) {
		String s = "06";

		System.out.println(numDecodings(s));

	}

}
