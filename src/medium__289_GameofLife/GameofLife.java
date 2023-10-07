package medium__289_GameofLife;

import java.util.Arrays;

public class GameofLife {
	
	/*
	 * Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]] Output:
	 * [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
	 */
	
	// m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0)

	 // Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules:
	//1.Any live cell with fewer than two live neighbors dies as if caused by under-population.
	//2.Any live cell with two or three live neighbors lives on to the next generation.
	//3.Any live cell with more than three live neighbors dies, as if by over-population.
	//4.Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

	
	//The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously. 
	//Given the current state of the m x n grid board, return the next state.
	
	// directions 
	
//	Here's a breakdown of each element in the directions array:

//	{-1, -1}: Represents the neighbor located one row above and one column to the left.
//	{-1, 0}: Represents the neighbor located one row above and in the same column.
//	{-1, 1}: Represents the neighbor located one row above and one column to the right.
//	{0, -1}: Represents the neighbor located in the same row and one column to the left.
//	{0, 1}: Represents the neighbor located in the same row and one column to the right.
//	{1, -1}: Represents the neighbor located one row below and one column to the left.
//	{1, 0}: Represents the neighbor located one row below and in the same column.
//	{1, 1}: Represents the neighbor located one row below and one column to the right.
	
	
	 public static void gameOfLife(int[][] board) {
		 int rows = board.length;
		    int cols = board[0].length;
		    int[][] newBoard = new int[rows][cols];

		    for (int i = 0; i < rows; i++) {
		        for (int j = 0; j < cols; j++) {
		            int liveNeighbors = countLiveNeighbors(i, j, board);

		            if (board[i][j] == 1) {
		                if (liveNeighbors < 2 || liveNeighbors > 3) {
		                    newBoard[i][j] = 0; // Cell dies due to underpopulation or overpopulation
		                } else {
		                    newBoard[i][j] = 1; // Cell lives on
		                }
		            } else {
		                if (liveNeighbors == 3) {
		                    newBoard[i][j] = 1; // Cell becomes alive due to reproduction
		                } else {
		                    newBoard[i][j] = 0; // Cell remains dead
		                }
		            }
		        }
		    }
		    
		    // Copy the new board back to the original board
 for (int i = 0; i < rows; i++) {
     System.arraycopy(newBoard[i], 0, board[i], 0, cols);
 }
		   
	      }
	 
	 
	 private static int countLiveNeighbors(int row, int col, int[][] board) {
		    int liveNeighbors = 0;
		    liveNeighbors += getLiveForHorizontal(row, col, board);
		    liveNeighbors += getLiveForVertical(row, col, board);
		    liveNeighbors += getLiveForDiagonal(row, col, board);
		    return liveNeighbors;
		}
	 
	 private static int getLiveForHorizontal(int row, int col, int[][] board) {
		    int liveCount = 0;
		    int cols = board[0].length;

		    int[] horizontalOffsets = {-1, 1};

		    for (int offset : horizontalOffsets) {
		        int newCol = col + offset;
		        if (newCol >= 0 && newCol < cols && board[row][newCol] == 1) {
		            liveCount++;
		        }
		    }

		    return liveCount;
		}

		private static int getLiveForVertical(int row, int col, int[][] board) {
		    int liveCount = 0;
		    int rows = board.length;

		    int[] verticalOffsets = {-1, 1};

		    for (int offset : verticalOffsets) {
		        int newRow = row + offset;
		        if (newRow >= 0 && newRow < rows && board[newRow][col] == 1) {
		            liveCount++;
		        }
		    }

		    return liveCount;
		}

		private static int getLiveForDiagonal(int row, int col, int[][] board) {
		    int liveCount = 0;
		    int rows = board.length;
		    int cols = board[0].length;

		    int[][] diagonalOffsets = {
		        {-1, -1}, {-1, 1}, {1, -1}, {1, 1}
		    };

		    for (int[] offset : diagonalOffsets) {
		        int newRow = row + offset[0];
		        int newCol = col + offset[1];

		        if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && board[newRow][newCol] == 1) {
		            liveCount++;
		        }
		    }

		    return liveCount;
		}

}
