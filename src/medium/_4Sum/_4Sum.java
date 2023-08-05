package _4Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _4Sum {

	public static List<List<Integer>> fourSum(int[] nums, int target) {
		// to solve it ypou need to add 4 items to gether if thos items avhive the sum
		// add this list to group list

		Arrays.sort(nums);

		int i = 0;
		int j = i + 1;
		int k = nums.length - 1;
		int k2 = k - 1;
		List<List<Integer>> returnedList = new ArrayList<>();

		int sum = 0;

		while(k2>j) {
			sum = nums[i] + nums[j] + nums[k] + nums[k2];
			
			System.out.println("the sum test = " + sum);
			if(sum==target) {
				returnedList.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k], nums[k2])));
				
			 }
			
			j++;
		}
		
		 i = 0;
		 j = i + 1;
		 k = nums.length - 1;
		 k2 = k - 1;
		while(k2>j) {
			sum = nums[i] + nums[j] + nums[k] + nums[k2];
			
			System.out.println("the sum test = " + sum);
			if(sum==target) {
				returnedList.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k], nums[k2])));
				
			}
			
			i++;
		}
		 i = 0;
		 j = i + 1;
		 k = nums.length - 1;
		 k2 = k - 1;
		while(k2>j) {
			sum = nums[i] + nums[j] + nums[k] + nums[k2];
			
			System.out.println("the sum test = " + sum);
			if(sum==target) {
				returnedList.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k], nums[k2])));
				
			}
			
			k2--;
		}
		 i = 0;
		 j = i + 1;
		 k = nums.length - 1;
		 k2 = k - 1;
		while(k2>j) {
			sum = nums[i] + nums[j] + nums[k] + nums[k2];
			
			System.out.println("the sum test = " + sum);
			if(sum==target) {
				returnedList.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k], nums[k2])));
				
			}
			
			k--;
		}

		
		return returnedList;

	}

	public static void main(String[] args) {

		int[] nums = {1,0,-1,0,-2,2 };
		int target = 0;

		System.out.println(fourSum(nums, target));

	}
}
