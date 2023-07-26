package medium._70_ClimbingStairs;

public class _70_ClimbingStairs {

	public static int climbStairs(int n) {
		int[] steps = new int[n + 1]; // We need n+1 elements to store steps[0] to steps[n].
		steps[0] = 1;
		steps[1] = 1;
		int maxSteps = 0;

		for (int i = 2; i <= n; i++) {
			steps[i] = steps[i - 1] + steps[i - 2];
			maxSteps=steps[i];
		}

		

		return maxSteps;
	}

	public static void main(String[] args) {
		System.out.println(climbStairs(3)  );

	}

}
