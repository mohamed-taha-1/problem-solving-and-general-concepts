package medium._167_TwoSumII_InputArrayIsSorted;

import java.util.Arrays;

public class _167_TwoSumII_InputArrayIsSorted {

	/*
	 * Given a 1-indexed array of integers numbers that is already sorted in
	 * non-decreasing order, find two numbers such that they add up to a specific
	 * target number. Let these two numbers be
	 */
	
	
	 public static  int[] twoSum(int[] numbers, int target) {
		 int left = 0;
	        int right = numbers.length - 1;

	        while (left < right) {
	            int sum = numbers[left] + numbers[right];

	            if (sum == target) {
	                return new int[]{left + 1, right + 1}; // Adding 1 to convert to 1-based indices
	            } else if (sum < target) {
	                left++;
	            } else {
	                right--;
	            }
	        }

	        throw new IllegalArgumentException("No solution found");
	    }
	public static void main(String[] args) {
		int[] nummbers= {2, 7, 11, 15};
		int target=19;
		
		System.out.println(Arrays.toString( twoSum(nummbers, target)));

	}

}
