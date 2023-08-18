package medium._120_Triangle;

import java.util.Arrays;
import java.util.List;

public class _120_Triangle {

	/*
	 * Given a triangle array, return the minimum path sum from top to bottom.
	 * 
	 * For each step, you may move to an adjacent number of the row below. More
	 * formally, if you are on index i on the current row, you may move to either
	 * index i or index i + 1 on the next row.
	 * 
	 */

//	Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
//			Output: 11
//			Explanation: The triangle looks like:
//			   2
//			  3 4
//			 6 5 7
//			4 1 8 3
//			The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).

	public static int minimumTotal(List<List<Integer>> triangle) {

		int length = triangle.size();
		for (int i = length - 2; i >= 0; i--) {
			List<Integer> currentRow = triangle.get(i);
			List<Integer> nextRow = triangle.get(i + 1);

			for (int j = 0; j < currentRow.size(); j++) {
				int currentElement = currentRow.get(j);

				int minSum = Math.min(nextRow.get(j + 1), nextRow.get(j)) + currentElement;
				currentRow.set(j, minSum);
				System.out.println(currentRow.get(0));
			}

		}
		return triangle.get(0).get(0);
	}

	public static void main(String[] args) {
		 List<List<Integer>> triangle = Arrays.asList(
		            Arrays.asList(2),
		            Arrays.asList(3, 4),
		            Arrays.asList(6, 5, 7),
		            Arrays.asList(4, 1, 8, 3)
		        );
	System.out.println(	minimumTotal(triangle));

	}

}
