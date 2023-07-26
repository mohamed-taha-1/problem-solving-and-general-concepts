package hard._37_SudokuSolver;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class _37_SudokuSolver {

	public static char[][] solveSudoku(char[][] board) {
		if (board == null || board.length == 0)
			return board;

		solveBacktrack(board);
		return board;
	}

	private static boolean solveBacktrack(char[][] board) {
		int n = board.length;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == '.') {
					for (char ch = '1'; ch <= '9'; ch++) {
						if (IsSudoku(board)) {
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

	private static boolean IsSudoku(char[][] board) {
		Map<Integer, HashSet<Character>> rowMap = new HashMap<>();
		Map<Integer, HashSet<Character>> colMap = new HashMap<>();
		Map<Integer, HashSet<Character>> boxMap = new HashMap<>();

		for (int i = 0; i < board.length; i++) {

			for (int j = 0; j < board[i].length; j++) {

				char current = board[i][j];

				if (current != '.') {

					// Check row duplicates
					if (rowMap.containsKey(i) && rowMap.get(i).contains(current)) {
						return false;
					} else {
						rowMap.putIfAbsent(i, new HashSet<>());
						rowMap.get(i).add(current);
					}

					// Check column duplicates
					if (colMap.containsKey(j) && colMap.get(j).contains(current)) {
						return false;
					} else {
						colMap.putIfAbsent(j, new HashSet<>());
						colMap.get(j).add(current);
					}

					// Check box duplicates
					int boxIndex = (i / 3) * 3 + (j / 3);

					if (boxMap.containsKey(boxIndex) && boxMap.get(boxIndex).contains(current)) {
						return false;
					} else {
						boxMap.putIfAbsent(boxIndex, new HashSet<>());
						boxMap.get(boxIndex).add(current);
					}

				}

			}
		}

		return true;

	}

	public static void main(String[] args) {
		 char[][] board1 = {
			        {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
			        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
			        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
			        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
			        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
			        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
			        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
			        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
			        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
			    };
			    
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
			    
			    
			    
			    char[][] board3 = {
			        {'8', '5', '.', '.', '.', '2', '4', '.', '.'},
			        {'7', '2', '.', '.', '.', '.', '.', '.', '9'},
			        {'.', '.', '4', '.', '.', '.', '.', '.', '.'},
			        {'.', '.', '.', '1', '.', '7', '.', '.', '2'},
			        {'3', '.', '5', '.', '.', '.', '9', '.', '.'},
			        {'.', '4', '.', '.', '.', '.', '.', '.', '.'},
			        {'.', '.', '.', '.', '8', '.', '.', '7', '.'},
			        {'.', '1', '7', '.', '.', '.', '.', '.', '.'},
			        {'.', '.', '.', '.', '3', '6', '.', '4', '.'}
			    };

	   // boeard1 
		char[][] solvedBoard = solveSudoku(board3);

		// Print the solved board
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(solvedBoard[i][j] + " ");
			}
			System.out.println();
		}
	}

}
