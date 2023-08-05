package nextPermutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NextPermutation {

	public static List<List<Integer>> permute(int[] nums) {
		if (nums.length <= 1)
			System.out.println(new ArrayList<>(Arrays.asList(nums)));

		List<List<Integer>> finalList = new ArrayList<>();

		for (int i = 0; i < nums.length; i++) {

			List<Integer> loop = new ArrayList<>();
			int trigger = nums[i];
			loop.add(trigger);

			for (int j = 0; j < nums.length; j++) {

				if (i == j)
					continue;

				loop.add(nums[j]);

			}

			finalList.add(loop);
			finalList.add(reverseList(loop));

		}
		
		
		
		// now reverse the order also to get all permuitations

		for (int i = nums.length - 1; i >= 0; i--) {

			List<Integer> loop = new ArrayList<>();
			int trigger = nums[i];
			loop.add(trigger);

			for (int j = nums.length - 1; j >= 0; j--) {

				if (i == j)
					continue;

				loop.add(nums[j]);

			}

			finalList.add(loop);
			finalList.add(reverseList(loop));

		}
		
		
		Set<List<Integer>> set=new HashSet<>(finalList);
		finalList.clear();
		finalList.addAll(set);
		List<List<Integer>> sortedList = finalList.stream().sorted(Comparator.comparing(list -> list.get(0))).toList();
		
		
		return sortedList;
	}
	
	
	

	
	public static List<Integer> reverseList(List<Integer> originalList) {
        List<Integer> reversedList = new ArrayList<>(originalList);
        int left = 0;
        int right = reversedList.size() - 1;

        while (left < right) {
            // Swap elements at left and right indices
            int temp = reversedList.get(left);
            reversedList.set(left, reversedList.get(right));
            reversedList.set(right, temp);

            left++;
            right--;
        }

        return reversedList;
    }
	

	public static void main(String[] args) {

		int[] nums = { 1, 2, 3 ,4};
		System.out.println(   permute(nums));

	}

}
