package medium._200_NumberofIslands;

public class _200_NumberofIslands {

	// Given an m x n 2D binary grid grid which represents a map of '1's (land) and
	// '0's (water), return the number of islands.

	/*
	 * An island is surrounded by water and is formed by connecting adjacent lands
	 * horizontally or vertically. You may assume all four edges of the grid are all
	 * surrounded by water.
	 */

	// Input: grid = [
	// ["1","1","1","1","0"],
	// ["1","1","0","1","0"],
	// ["1","1","0","0","0"],
	// ["0","0","0","0","0"]
	// ]
	// Output: 1

	// Input: grid = [
	// ["1","1","0","0","0"],
	// ["1","1","0","0","0"],
	// ["0","0","1","0","0"],
	// ["0","0","0","1","1"]
	// ]
	// Output: 3

	// count ++ if there are 4 '0's
	public static int numIslands(char[][] grid) {

		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}

		int numRows = grid.length;
		int numCols = grid[0].length;
		int count = 0;
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				if (grid[i][j] == '1') {
					count++;
					dfs(grid, i, j);
				}
			}
		}
		return count;
	}

	private static void dfs(char[][] grid, int row, int col) {
		int numRows = grid.length;
		int numCols = grid[0].length;

		if (row < 0 || col < 0 || row >= numRows || col >= numCols || grid[row][col] != '1') {
			return;
		}

		grid[row][col] = '0';

		// all neighboring cells
		dfs(grid, row + 1, col);
		dfs(grid, row - 1, col);
		dfs(grid, row, col + 1);
		dfs(grid, row, col - 1);

	}

	public static void main(String[] args) {
		char[][] grid = { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '0', '0', '0' },
				{ '0', '0', '0', '1', '1' } };

		System.out.println(numIslands(grid));

	}

}
