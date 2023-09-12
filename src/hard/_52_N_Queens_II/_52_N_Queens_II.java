package hard._52_N_Queens_II;

public class _52_N_Queens_II {

	/*
	 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard
	 * such that no two queens attack each other.
	 * 
	 * Given an integer n, return the number of distinct solutions to the n-queens
	 * puzzle.
	 * 
	 * // Input: n = 4 Output: 2 Explanation: There are two distinct solutions to
	 * the 4-queens puzzle as shown.
	 */

	public static int totalNQueens(int n) {
		int[] cols = new int[n];
		return backTrack(0, cols, n);

	}

	private static int backTrack(int rows, int[] cols, int n) {

		// base case
		if (rows == n) {
			return 1;
		}

		int count = 0;
		for (int col = 0; col < n; col++) {
			if (isValidPlacement(rows, col, cols)) {
				cols[rows] = col;
				count += backTrack(rows + 1, cols, n);
			}
		}

		return count;

	}

	private static boolean isValidPlacement(int row, int col, int[] cols) {
		for (int i = 0; i < row; i++) {
			// Check if the queen can attack another queen in the same column or diagonals
			if (cols[i] == col || Math.abs(cols[i] - col) == Math.abs(i - row)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int n = 4;
		System.out.println(totalNQueens(n));

	}

}
