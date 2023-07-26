package hard._37_SudokuSolver;

public class Solution2 {

	public static char[][] solveSudoku(char[][] board) {

		solveBacktrack(board);
        return board;
	}

	private static boolean solveBacktrack(char[][] board) {
		int n = board.length;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == '.') {
					for (char ch = '1'; ch <= '9'; ch++) {
						if (IsSudoku(board, i, j, ch)) {
							board[i][j] = ch;

							if (solveBacktrack(board)) {
								return true;
							}

							board[i][j] = '.';
						}
					}
					return false;
				}
			}
		}
		return true;
	}

	private static boolean IsSudoku(char[][] board, int row, int col, char ch) {
		for (int i = 0; i < 9; i++) {
			if (board[i][col] == ch || board[row][i] == ch
					|| board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == ch) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {

		char[][] board2 = {  
	        {'.', '.', '.', '.', '.', '.', '5', '.', '.'},
	        {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
	        {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
	        {'9', '3', '.', '.', '2', '.', '4', '.', '.'},
	        {'.', '.', '7', '.', '.', '.', '3', '.', '.'},
	        {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
	        {'.', '.', '.', '3', '4', '.', '.', '.', '.'},
	        {'.', '.', '.', '.', '.', '3', '.', '.', '.'},
	        {'.', '.', '.', '.', '.', '5', '2', '.', '.'}
	     };

// boeard1 
		char[][] solvedBoard2= solveSudoku(board2);

// Print the solved board
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(solvedBoard2[i][j] + " ");
			}
			System.out.println();
		}
	}

}
