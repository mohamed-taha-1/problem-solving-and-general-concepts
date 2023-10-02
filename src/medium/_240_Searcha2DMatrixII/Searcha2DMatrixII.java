package medium._240_Searcha2DMatrixII;

public class Searcha2DMatrixII {

	public static boolean searchMatrix(int[][] matrix, int target) {
		 if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
		        return false;
		    }
		 
		 int numRows = matrix.length;
		    int numCols = matrix[0].length;
		    
		    int row=0, col=numCols-1;
		    while(row<numRows &&col>=0) {
		    	if(matrix[row][col]==target) return true;
		    	 else if( matrix[row][col] <target) { row++;}
		    	 else col--;
		    }
		return false;
	}

	public static void main(String[] args) {
		int[][] matrix= {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
		int target=20;
		System.out.println( searchMatrix(matrix, target) );

	}

}
