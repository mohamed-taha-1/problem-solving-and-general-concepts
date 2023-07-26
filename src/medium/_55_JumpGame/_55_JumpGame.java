package medium._55_JumpGame;

import java.util.ArrayList;
import java.util.List;

public class _55_JumpGame {
	public static boolean canJump(int[] nums) {

		int n = nums.length;
	    int maxReachable = 0; // Initialize the maximum reachable position.

	    for (int i = 0; i <= maxReachable; i++) {
	        int jump = i + nums[i];
	        maxReachable = Math.max(maxReachable, jump);

	        if (maxReachable >= n - 1) {
	            return true; // If the last index is reachable, return true.
	        }
	    }

	    return false; 
	}

	public static void main(String[] args) {
		int[] nums = { 2, 3, 1, 1, 4 };

		System.out.println("Can jumb:\t" + canJump(nums));

	}

}
