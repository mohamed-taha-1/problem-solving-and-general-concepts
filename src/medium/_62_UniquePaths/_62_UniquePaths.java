package medium._62_UniquePaths;

import java.util.Arrays;

public class _62_UniquePaths {

	
	//return the number of possible unique paths that the robot can take to reach the bottom-right corner.
	// return back the number of rights + downs.

	public static int uniquePaths(int m, int n) {

		/* m: your desired number of rows */;
		/* n: your desired number of columns */;
		int[][] matrix = new int[m][n];

		int left = 0, right = n - 1;
		int top = 0, down = m - 1;

		// Fill the rightmost column with 1s
		for (int i = 0; i < m; i++) {
			matrix[i][right] = 1;
		}

		// Fill the bottom row with 1s
		for (int i = 0; i < n; i++) {
			matrix[down][i] = 1;
		}
		down--;

		// Fill the interior elements with the sum of the element above and to the left
		int sum = 0;
		for (int i = down; i >= top; i--) {
			for (int j = right - 1; j >= left; j--) {
				sum = matrix[i + 1][j] + matrix[i][j + 1];
				matrix[i][j] = sum;
			}
		}

		for (int i = 0; i < matrix.length; i++) { // all rights + all downs
			System.out.println(Arrays.toString(matrix[i]));
		}

		return matrix[0][0];
	}
	 
	  
	  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	System.out.println(	uniquePaths(3,2));

	}

}
