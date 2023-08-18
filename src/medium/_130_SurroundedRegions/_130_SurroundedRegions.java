package medium._130_SurroundedRegions;

public class _130_SurroundedRegions {

	/*
	 * Given an m x n matrix board containing 'X' and 'O', capture all regions that
	 * are 4-directionally surrounded by 'X'.
	 * 
	 * A region is captured by flipping all 'O's into 'X's in that surrounded
	 * region.
	 */

//	Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
//			Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
//			Explanation: Notice that an 'O' should not be flipped if:
//			- It is on the border, or
//			- It is adjacent to an 'O' that should not be flipped.
//			The bottom 'O' is on the border, so it is not flipped.
//			The other three 'O' form a surrounded region, so they are flipped.

//	Example 2:
//
//		Input: board = [["X"]]
//		Output: [["X"]]

	public static void solve(char[][] board) {
		int rows = board.length;
		if (rows == 0)
			return;

		int cols = board[0].length;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (board[i][j] == 'O') {

					boolean isOnBorder = i == 0 || j == 0 || i == rows - 1 || j == cols - 1;
					if (isOnBorder) {
						// If an 'O' is on the border, perform a depth-first search
						dfs(board, i, j);
					}

				}

			}
		}

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {

				if (board[i][j] == 'O') {
					board[i][j] = 'X';
				}
				if (board[i][j] == 'T')
					board[i][j] = 'O';
			}
		}

	}

	private static void dfs(char[][] board, int row, int col) {

		int rows = board.length;
		int cols = board[0].length;

		if (row < 0 || row >= rows || col < 0 || col >= cols || board[row][col] != 'O') {
			return;
		}

		board[row][col] = 'T';

		dfs(board, row + 1, col);
		dfs(board, row - 1, col);
		dfs(board, row, col + 1);
		dfs(board, row, col - 1);

	}

	public static void main(String[] args) {
		char[][] borad = { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' },
				{ 'X', 'O', 'X', 'X' } };
		solve(borad);

	}

}
