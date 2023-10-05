package medium._300_LongestIncreasingSubsequence;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

	/*
	 * Input: nums = [10,9,2,5,3,7,101,18] Output: 4 Explanation: The longest
	 * increasing subsequence is [2,3,7,101], therefore the length is 4.
	 */
	public static int lengthOfLIS(int[] nums) {

		 if (nums.length == 0) {
		        return 0; // Handle the case of an empty array.
		    }

		    int[] dp = new int[nums.length];
		    dp[0] = nums[0];
		    int counter = 0;

		    for (int i = 1; i < nums.length; i++) {
		        if (dp[counter] < nums[i]) {
		            counter++;
		            dp[counter] = nums[i];
		        } else {
		            // Find the appropriate position to update dp
		            int left = 0;
		            int right = counter;
		           
		            while (left < right) {
		                int mid = left + (right - left) / 2;
		                if (dp[mid] < nums[i]) {
		                    left = mid + 1;
		                } else {
		                    right = mid;
		                }
		            }
		            dp[left] = nums[i];
		        }
		    }

		    return counter + 1;
		}

	public static void main(String[] args) {
		int[] arr = { 10,9,2,5,3,7,101,18 };
		System.out.println(lengthOfLIS(arr));

	}

}
