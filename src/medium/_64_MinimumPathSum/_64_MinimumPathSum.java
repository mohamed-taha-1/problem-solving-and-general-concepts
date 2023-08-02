package medium._64_MinimumPathSum;

import java.util.Arrays;

public class _64_MinimumPathSum {

	public static int minPathSum(int[][] grid) {
		int row = grid.length;
		int col = grid[0].length;

		int left = 0, right = col - 1;
		int top = 0, down = row - 1;

		int[][] matrix = new int[row][col];
		matrix[0][0] = grid[0][0];

		for (int i = 1; i < col; i++) {
			matrix[0][i] = grid[0][i] + matrix[0][i - 1];
		}
		for (int i = 1; i < row; i++) {
			matrix[i][0] = grid[i][0] + matrix[i - 1][0];
		}

		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {

				matrix[i][j] = grid[i][j] + Math.min(matrix[i - 1][j],  matrix[i][j - 1]);

			}
		}

		return matrix[row - 1][col - 1];
	}

	public static void main(String[] args) {
		int[][] grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };

		System.out.println(  minPathSum(grid));

	}

}
