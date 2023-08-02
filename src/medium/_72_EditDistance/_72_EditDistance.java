package medium._72_EditDistance;

import java.util.Arrays;

public class _72_EditDistance {

	public static int minDistance(String word1, String word2) {

		 int m = word1.length();
		    int n = word2.length();
		  int[][] dp = new int[m + 1][n + 1];
		  
		    for (int i = 0; i <= m; i++) {
		        dp[i][0] = i;
		    }

		    for (int j = 0; j <= n; j++) {
		        dp[0][j] = j;
		    }
		    
		    // Fill the DP matrix
		    for (int i = 1; i <= m; i++) {
		        for (int j = 1; j <= n; j++) {
		       
		        	if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
		        		 dp[i][j] = dp[i - 1][j - 1];
		        		 
		        	}else {
		        		 dp[i][j] = 1 + Math.min(dp[i - 1][j - 1] ,Math.min(dp[i][j - 1], dp[i - 1][j]));
		        	}
		        
		        }}

		    for (int[] row : dp) {
	            for (int element : row) {
	                System.out.print(element + " ");
	            }
	            System.out.println(); // Move to the next line after printing each row
	        }
	    
		
		    return dp[m-1][n-1];

	}

	public static void main(String[] args) {
		String word2 = "ros";
		String word1 = "horse";
		
	

		minDistance(word1, word2);

	}

}
