package medium._179_LargestNumber;

import java.util.Arrays;

public class _179_LargestNumber {

	public static String largestNumber(int[] nums) {

		if (nums == null || nums.length == 0) {
			return "";
		}

		StringBuilder sb = new StringBuilder();

		String[] strArray = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {

			strArray[i] = String.valueOf(nums[i]);
		}
		
		Arrays.sort(strArray, (a,b)-> (b+a).compareTo(a+b) );

		if(strArray[0]=="0") return"0"; // If the largest number is "0", return "0"
		
		for(String str:strArray) sb.append(str);
		
		return sb.toString();
	}

	public static void main(String[] args) {
		int[] nums = {3,30,34,5,9 };

		System.out.println(largestNumber(nums));

	}

}
