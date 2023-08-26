package medium._189_RotateArray;

public class _189_RotateArray {
	// Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
	
	
		//	        Input: nums = [1,2,3,4,5,6,7], k = 3
		//			Output: [5,6,7,1,2,3,4]
		//			Explanation:
		//			rotate 1 steps to the right: [7,1,2,3,4,5,6]
		//			rotate 2 steps to the right: [6,7,1,2,3,4,5]
		//			rotate 3 steps to the right: [5,6,7,1,2,3,4]

	
		//        	Input: nums = [-1,-100,3,99], k = 2
		//			Output: [3,99,-1,-100]
		//			Explanation: 
		//			rotate 1 steps to the right: [99,-1,-100,3]
		//			rotate 2 steps to the right: [3,99,-1,-100]
	
	
	 public static  void rotate(int[] nums, int k) {
		 int n=nums.length;
		  k = k % n; // To handle cases where k is greater than n

		    for (int i = 0; i < k; i++) {
		        // Store the last element to rotate
		        int last = nums[n - 1];
		        
		        // Shift elements to the right by one position
		        for (int j = n - 1; j > 0; j--) {
		            nums[j] = nums[j - 1];
		        }
		        
		        // Place the last element at the beginning
		        nums[0] = last;
		    }
	    }
	
	public static void main(String[] args) {
		int[] nums= {1,2,3,4,5,6,7};  int k=3;
		
     rotate(nums, k);
     
      for(int num:nums) System.out.println(num);
     
	}

}
