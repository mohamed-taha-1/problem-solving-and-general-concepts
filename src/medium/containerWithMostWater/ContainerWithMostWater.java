package medium.containerWithMostWater;

public class ContainerWithMostWater {

	public static int maxArea(int[] height) {
		int p1 = 0;
		int p2 = height.length - 1;
		int max = 0;

		while (p1 < p2) {
			int currentHeight = Math.min(height[p1], height[p2]);
			int currentWidth = p2 - p1;
			int currentArea = currentHeight * currentWidth;
			max = Math.max(max, currentArea);

			if (height[p1] < height[p2]) {
				p1++;
			} else {
				p2--;
			}

		}
		return max;
	}

	public static void main(String[] args) {

		// now we try to find out the max height of the containers

		int[] nums = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };

		System.out.println(maxArea(nums));

	}

}
