package medium._48_RotateImage;

import java.util.Arrays;

public class _48_RotateImage {

	public static void rotate(int[][] matrix) {

		// Step 1: Transpose the matrix
	    for (int i = 0; i < matrix.length; i++) {
	        for (int j = i; j < matrix[i].length; j++) {
	            int temp = matrix[i][j];
	            matrix[i][j] = matrix[j][i];
	            matrix[j][i] = temp;
	        }
	    }

	    // Step 2: Reverse each row
	    for (int i = 0; i < matrix.length; i++) {
	        int left = 0;
	        int right = matrix[i].length - 1;
	        while (left < right) {
	            int temp = matrix[i][left];
	            matrix[i][left] = matrix[i][right];
	            matrix[i][right] = temp;
	            left++;
	            right--;
	        }
	    }
		
		
		

	}



	public static void main(String[] args) {
		// matrix ; rotate the image by 90 degrees (clockwise).

		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		rotate(matrix);

	}

}
