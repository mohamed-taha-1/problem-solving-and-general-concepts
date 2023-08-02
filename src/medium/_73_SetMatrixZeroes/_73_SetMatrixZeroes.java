package medium._73_SetMatrixZeroes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _73_SetMatrixZeroes {

	public static void setZeroes(int[][] matrix) {

		int row = matrix.length;
		int col = matrix[0].length;

		List<Integer> zeroRows = new ArrayList<>();
		List<Integer> zeroCols = new ArrayList<>();

		// Find the rows and columns containing zeroes
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] == 0) {
					zeroRows.add(i);
					zeroCols.add(j);
				}
			}
		}

		for (int nn : zeroRows) {
			for (int i = 0; i < col; i++) {
				matrix[nn][i] = 0;
			}
		}

		for (int nn : zeroCols) {

			for (int i = 0; i < row; i++) {

				matrix[i][nn] = 0;
			}
		}

		for (int arr3[] : matrix) {
			System.out.println(Arrays.toString(arr3));
		}

	}

	public static void main(String[] args) {
		int[][] matrix = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };

		setZeroes(matrix);

	}

}
