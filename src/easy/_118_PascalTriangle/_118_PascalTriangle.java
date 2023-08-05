package _118_PascalTriangle;

import java.util.ArrayList;
import java.util.List;

public class _118_PascalTriangle {

	public static List<List<Integer>> generate(int numRows) {

		List<List<Integer>> result = new ArrayList<>();

		if (numRows <= 0) {
			return result;
		}
		for (int i = 0; i < numRows; i++) {
			List<Integer> current = new ArrayList<>();
			for (int j = 0; j <= i; j++) {

				if (j == 0 || j == i) {
					current.add(1);
				} else {

					List<Integer> prevRow = result.get(i - 1);
					int val = prevRow.get(j - 1) + prevRow.get(j);
					current.add(val);

				}

			}

			result.add(current);

		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(generate(5));
	}

}
