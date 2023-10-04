package medium._279_PerfectSquares;

import java.util.Arrays;

public class PerfectSquares {

	 public static  int numSquares(int n) {
//		 List<Integer> list=new ArrayList<>();
//		 for (int i = i; i <= n; i++) {
//		      
//		        	
//		        	for (int j = 1; j*j <= i; j++)  {
//		   			 if (j % (i * i) == 0) {
//		   		             list.add(i*i);
//		   		             j=n-j;
//		   		        }
//		   			 
//		   			 if(j==0) return list.size();
//		   		 }
//		   		 
//		        }
//		    }
		 
		 int[] dp = new int[n + 1];
		 Arrays.fill(dp, Integer.MAX_VALUE);
		 dp[0]=0;
		 for (int i = 1; i <= n; i++) {
			 for (int j = 1; j*j <= i; j++) {
				 dp[i]=Math.min(dp[i], dp[i- j*j]+1);
			 }
		 }
	        return dp[n];
	    }
	public static void main(String[] args) {
		int n=12;
		System.out.println(numSquares(n));

	}

}
