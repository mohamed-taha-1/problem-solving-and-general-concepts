package medium._213_HouseRobberII;

public class _213_HouseRobberII {
//	You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. 
//	 Each house has a certain amount of money stashed
//	.. All houses at this place are arranged in a circle.
//	... That means the first house is the neighbor of the last one
//	...Meanwhile, adjacent houses have a security system connected
//	..the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

	// Given an integer array nums representing the amount of money of each house,
//	Given an integer array nums representing the amount of money of each house,

//	ex: Input: nums = [2,3,2] .. Output: 3

//	ex2:Input: nums = [1,2,3,1] .. Output: 4

//	ex: Input: nums = [1,2,3] >> Output: 3

	/*
	 * if (nums == null || nums.length == 0) { return 0; }
	 * 
	 * int n = nums.length; if (n == 1) { return nums[0]; }
	 * 
	 * // Calculate the maximum amount if the first house is robbed and the last
	 * house is not. int max1 = robLinear(nums, 0, n - 2);
	 * 
	 * // Calculate the maximum amount if the first house is not robbed and the last
	 * house is. int max2 = robLinear(nums, 1, n - 1);
	 * 
	 * return Math.max(max1, max2); } private static int robLinear(int[] nums, int
	 * start, int end) { int prevMax = 0; int currMax = 0;
	 * 
	 * for (int i = start; i <= end; i++) { int temp = currMax; currMax =
	 * Math.max(prevMax + nums[i], currMax); prevMax = temp; }
	 * 
	 * return currMax; }}
	 */
	public static int rob(int[] nums) {

		if(nums==null || nums.length==0) return 0;
		int n=nums.length;
		if(n==1) return nums[0];
		int max1=helper(nums, 0,n-2);
		int max2=helper(nums, 1,n-1);
		
		
		return Math.max(max1, max2);
	}
	private static int helper(int[] nums, int start, int end) {
		int currMax=0;
		int prevMax=0;
		
		for(int i=start;i<=end;i++) {
			  int temp=currMax;
			  currMax=Math.max(prevMax+nums[i], currMax);
			  prevMax=temp;
		}
		
		return currMax;
	}

	public static void main(String[] args) {
		int[] nums = { 1,2,3,1};
		System.out.println(rob(nums));

	}

}
