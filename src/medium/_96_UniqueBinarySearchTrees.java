package medium;

import java.util.List;

public class _96_UniqueBinarySearchTrees {
	
	 public static int numTrees(int n) {
		  if (n <= 0) {
	            return 0;
	        }
	        
	        int[] dp = new int[n + 1];
	        dp[0] = 1;
	        dp[1] = 1;
	        
	        for (int i = 2; i <= n; i++) {
	            for (int j = 1; j <= i; j++) {
	                dp[i] += dp[j - 1] * dp[i - j];
	            }
	        }
	        
	        
	        
	        return dp[n];
	    }
	 


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(numTrees(3));
	}

}
