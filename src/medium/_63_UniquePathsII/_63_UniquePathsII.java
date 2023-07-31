package medium._63_UniquePathsII;

import java.util.Arrays;

public class _63_UniquePathsII {

	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {

	
		int rows = obstacleGrid.length;
	    int cols = obstacleGrid[0].length;

	    // If the starting cell or the ending cell is blocked, there are no paths
	    if (obstacleGrid[0][0] == 1 || obstacleGrid[rows - 1][cols - 1] == 1) {
	        return 0;
	    }

	    // Initialize the DP array
	    int[][] dp = new int[rows][cols];

	    // Base case: there is one path to reach the cells in the first row and first column
	    for (int i = 0; i < rows; i++) {
	        if (obstacleGrid[i][0] == 0) {
	            dp[i][0] = 1;
	        } else {
	            break; // If there's an obstacle, stop calculating further paths
	        }
	    }

	    for (int j = 0; j < cols; j++) {
	        if (obstacleGrid[0][j] == 0) {
	            dp[0][j] = 1;
	        } else {
	            break; // If there's an obstacle, stop calculating further paths
	        }
	    }

	    // Fill the DP array by considering obstacles and calculating the number of paths
	    for (int i = 1; i < rows; i++) {
	        for (int j = 1; j < cols; j++) {
	            if (obstacleGrid[i][j] == 0) {
	                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
	            }
	        }
	    }

	    return dp[rows - 1][cols - 1];

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] obstacleGrid = { { 0} };
		System.out.println(uniquePathsWithObstacles(obstacleGrid));

	}

}
