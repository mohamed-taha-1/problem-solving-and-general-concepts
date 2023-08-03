package medium._79_WordSearch;

public class _79_WordSearch {

	public static boolean exist(char[][] board, String word) {

		int row = board.length;
		int col = board[0].length;
		char[] arr = word.toCharArray();

		// Perform DFS for each cell in the board
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (dfs(board, arr, i, j, 0))
					return true;
			}
		}
		return false;
	}

	private static boolean dfs(char[][] board, char[] word, int i, int j, int k) {
		int row = board.length;
		int col = board[0].length;

		// Check if indices are out of bounds or the character does not match
		if (i < 0 || i >= row || j < 0 || j >= col || board[i][j] != word[k])
			return false;

		// If all characters of the word have been matched, return true
		if (k == word.length - 1)
			return true;

		// Mark the current cell as visited (using a temporary placeholder)
		char temp = board[i][j];
		board[i][j] = '#';

		// Explore the neighbors (up, down, left, right) in a DFS manner
		boolean found = dfs(board, word, i - 1, j, k + 1) || dfs(board, word, i + 1, j, k + 1)
				|| dfs(board, word, i, j - 1, k + 1) || dfs(board, word, i, j + 1, k + 1);

		// Restore the original character in the board
		board[i][j] = temp;

		return found;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		String word = "ABCCED";

		System.out.println(exist(board, word));

	}

}
