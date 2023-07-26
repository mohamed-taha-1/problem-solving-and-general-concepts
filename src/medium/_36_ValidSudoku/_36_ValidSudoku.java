package medium._36_ValidSudoku;

import java.util.HashMap;
import java.util.HashSet;

public class _36_ValidSudoku {

	public static boolean isValidSudoku(char[][] board) {

		HashMap<Integer, HashSet<Character>> rowMap = new HashMap<>();
		HashMap<Integer, HashSet<Character>> colMap = new HashMap<>();
		HashMap<Integer, HashSet<Character>> boxMap = new HashMap<>();
		
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
	        }}

		return true;
	}

	public static void main(String[] args) {
		 char[][] board = {
			        {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
			        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
			        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
			        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
			        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
			        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
			        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
			        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
			        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
			    };

			    boolean isValid = isValidSudoku(board);
			    System.out.println("Is the Sudoku board valid? " + isValid);

	}

}
