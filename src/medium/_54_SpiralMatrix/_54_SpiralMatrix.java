package medium._54_SpiralMatrix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _54_SpiralMatrix {

	public static List<Integer> spiralOrder(int[][] matrix) {

		List<Integer> listAdded = new ArrayList<>();
		Map<Integer, Integer> mapped = new HashMap<>();

		for (int i = 0; i < matrix.length; i++) {
			int right = 0;
			int lastCol = 0;

			for (int j = 0; j < matrix[i].length; j++) {
				right = matrix[j].length - 1;

				if (i == 0) {
					listAdded.add(matrix[0][j]);
				}

			}

			lastCol = matrix[i][right];

			if (i > 0) {
				mapped.put(i, lastCol);
				listAdded.add(lastCol);
			}
		}

		// last row insert

		for (int i = matrix.length - 1; i >= 0; i--) {

			for (int j = matrix[i].length - 2; j >= 0; j--) {

				if (i == matrix.length - 1) {
					if (!mapped.containsKey(matrix[matrix.length - 1][matrix[i].length - 1])) {
						listAdded.add(matrix[matrix.length - 1][j]);
					}
				}

			}

		}

		// every row between them now

		for (int i = matrix.length - 2; i > 0; i--) {

			for (int j = 0; j < matrix[i].length - 1; j++) {

				listAdded.add(matrix[i][j]);

			}

		}

		return listAdded;

	}

	public static void main(String[] args) {
		int[][] matrix = { {1,2,3,4},{5,6,7,8},{9,10,11,12} };

		System.out.println(spiralOrder(matrix)); 
		/*
		 * Expected: [1,2,3,4,8,12,11,10,9,5,6,7] 
		 * actually:
		 */

	}

}
