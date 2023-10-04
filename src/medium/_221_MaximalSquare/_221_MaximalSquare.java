package medium._221_MaximalSquare;

public class _221_MaximalSquare {

	public static int maximalSquare(char[][] matrix) 
	{
		int rows = matrix.length;
		int cols = matrix[0].length;
        int[][] dp=new int[rows][cols];
        int max=0;
		
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) 
            {
                   if(matrix[i][j]=='1') 
                   {
                	   if(i==0 || j==0) dp[i][j]=1;
                	   else 
                	   {
                		   dp[i][j]=Math.min(Math.min(dp[i-1][j], dp[i][j-1]) ,dp[i-1][j-1])+1;
                	   }
                	   max=Math.max(max, dp[i][j]);
                   }
			}
		}
		return max*max;
	}

	public static void main(String[] args) 
	{
		char[][] matrix = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
				{ '1', '0', '0', '1', '0' } };
		char[][] matrix2 = { { '0', '1' }, { '1', '0' } };
		System.out.println(maximalSquare(matrix));
	}

}
