package medium._33_SearchinRotatedSortedArray;

import java.util.Arrays;

public class _33_SearchinRotatedSortedArray {

	// we will use binary search for that reason!
	// --- here we will built a binary search mechanism that return a -1 if not
	// fount else return the target

	public static int search(int[] nums, int target) {
		int n = nums.length;
		int i = 0;
		int tarRet = -1;

		for (; i < nums[n / 2]; i++) {

			if (target != nums[i]) {
				int temp = nums[0];
				nums[0] = nums[n - 1];
				nums[n - 1] = temp;

			} else {
				tarRet = i;
			}
		}

		return tarRet;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
		int target = 4;

		System.out.println(search(nums, target));
	}

}
