package removeElement;

import java.util.HashMap;
import java.util.Map;

public class RemoveElement {

	public static int removeElement(int[] nums, int val) {

		int i = 0;
		int n = nums.length;

		for (int j = 0; j < n; j++) {
			if (nums[j] != val) {
				nums[i] = nums[j];
				i++;
			}
		}

		return i;
	}

	public static void main(String[] args) {

		int[] nums = { 3, 2, 2, 3 };
		int val = 3;

		System.out.println(removeElement(nums, val));

	}
}
