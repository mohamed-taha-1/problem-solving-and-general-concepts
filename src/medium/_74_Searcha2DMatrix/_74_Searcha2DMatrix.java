package medium._74_Searcha2DMatrix;

public class _74_Searcha2DMatrix {

	 public static  boolean searchMatrix(int[][] matrix, int target) {
	        
		 int row=matrix.length;
		 int col=matrix[0].length;
		 
		 for(int i=0;i<row;i++) {
			 for(int j=0;j<col;j++) {
				 if(matrix[i][j]==target) return true;
			 }
		 }
		 
		 
		 
		 return false;
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] matrix= {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
		
		
		System.out.println(searchMatrix(matrix, 3) );
		
	}

}
