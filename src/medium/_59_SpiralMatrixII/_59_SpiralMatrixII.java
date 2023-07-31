package medium._59_SpiralMatrixII;

import java.util.Arrays;

public class _59_SpiralMatrixII {

	public static int[][] generateMatrix(int n) {

		int counter = 1;
		int left = 0, right = n - 1;
		int top = 0, down = n - 1;
		int[][] matrix = new int[n][n];

		while (counter <= n * n) {
			for (int i = left; i <= right; i++) {
				matrix[top][i] = counter++;
			}

			top++; // top==1
			for (int i = top; i <= down; i++) {
				matrix[i][right] = counter++;

			}

			right--; // right=2 not 3
			for (int i = right; i >= left; i--) {
				matrix[down][i] = counter++;

			}
			down--;
			for (int i = down; i >= top; i--) {
				matrix[i][left] = counter++;
			}

			left++;

		}

		for (int i = 0; i < matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}

		return matrix;
	}

	public static void main(String[] args) {
		generateMatrix(4);

	}

}
