package medium._54_SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

public class Soluion2 {

	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> listAdded = new ArrayList<>();

		if (matrix == null || matrix.length == 0) {
			return listAdded;
		}

		int rows = matrix.length;
		int cols = matrix[0].length;

		int top = 0, bottom = rows - 1;
		int left = 0, right = cols - 1;

		while (left <= right && top <= bottom) {

			// Traverse the top row from left to right
			for (int i = left; i <= right; i++) {
				listAdded.add(matrix[top][i]);

			}
			top++;

			// Traverse the rightmost column from top to bottom
			for (int i = top; i <= bottom; i++) {

				listAdded.add(matrix[i][right]);
			}

			right--;

			// Check if we have traversed all rows and columns
			if (top <= bottom) {

				// Traverse the bottom row from right to left
				for (int j = right; j >= left; j--) {
					listAdded.add(matrix[bottom][j]);
				}
				bottom--;
			}

			if (left <= right) {
				// Traverse the leftmost column from bottom to top

				for (int i = bottom; i >= top; i--) {
					listAdded.add(matrix[i][left]);

				}

				left++;
			}

		}

		return listAdded;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.println(spiralOrder(matrix));
		/*
		 * Expected: [1,2,3,6,9,8,7,4,5] actually:[1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6,
		 * 7]
		 */

	}

}
