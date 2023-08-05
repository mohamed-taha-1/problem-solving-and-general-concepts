package _4Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Solution2 {
	public static List<List<Integer>> fourSum(int[] nums, int target) {
		// to solve it ypou need to add 4 items to gether if thos items avhive the sum
		// add this list to group list
	
		Arrays.sort(nums);
		for (int f=0;f<nums.length;f++) {
			if (target< 0 && nums[f]>0 ) return new  ArrayList<>();
		}
		

		List<List<Integer>> returnedList = new ArrayList<>();

		int i = 0;
		while (i < nums.length - 3) {
			int j = i + 1;
			while (j < nums.length - 2) {

				int k = j + 1;
				int k2 = nums.length - 1;

				while (k < k2) {
					int sum = nums[i] + nums[j] + nums[k] + nums[k2];

					if (sum == target) {
						returnedList.add(Arrays.asList(nums[i], nums[j], nums[k], nums[k2]));
						k++;
						k2--;

						while (k < k2 && nums[k] == nums[k - 1])
							k++;

						while (k < k2 && nums[k2] == nums[k2 + 1])
							k2--;
					} else if (sum < target) {
						k++;
					} else {
						k2--;
					}
				}

				j++;
			}

			i++;
		}

		
		return returnedList;
	}

	public static void main(String[] args) {

		int[] nums = {1000000000,1000000000,1000000000,1000000000 };
		int target = -294967296;

		System.out.println(fourSum(nums, target));

	}

}
