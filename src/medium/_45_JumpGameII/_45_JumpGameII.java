package medium._45_JumpGameII;

public class _45_JumpGameII {

	public static int jump(int[] nums) {
		if (nums == null || nums.length <= 1) {
			return 0; // No jumps needed if there is only one element or no elements
		}
		int maxJum = 0;
		int max = 0;
		int jumps = 0;
		int currentEndJumbs = 0;

		for (int i = 0; i < nums.length; i++) {

			maxJum = nums[i] + i;
			max = Math.max(max, maxJum);

			// If we reach the end of the current jump, make the next jump
			if (i == currentEndJumbs) {
				jumps++;
				currentEndJumbs = max;
			}

			// If we can already reach the end, no need to check further
			if (currentEndJumbs >= nums.length - 1) {
				break;
			}

		}

		System.out.println(" \n the min ===== \n :" + maxJum);
		return jumps;
	}

	public static void main(String[] args) {
		// Return the minimum number of jumps to reach { NUMS[n - 1] }

		int[] nums = { 0 };
		System.out.println(" the differnce is :" + jump(nums));

	}

}
