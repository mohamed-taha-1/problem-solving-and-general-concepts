package medium._153_FindMinimuminRotatedSortedArray;

public class _153_FindMinimuminRotatedSortedArray {

	public static int findMin(int[] nums) {
	    return binarySearch(nums, 0, nums.length - 1);
	}

	private static int binarySearch(int[] nums, int left, int right) {
		 if (left == right) {
		        return nums[left]; // Only one element left, it is the minimum.
		    }

	    int mid = left + (right - left) / 2;
	    // Compare the mid element with the left and right elements
	    if (nums[left] < nums[right]) {
	        // The array between 'left' and 'right' is sorted in ascending order.
	        // Return the minimum element from 'left' index.
	        return nums[left];
	    } else {
	        if (nums[mid] < nums[left]) {
	            // The minimum element is in the left half.
	            return binarySearch(nums, left, mid);
	        } else {
	            // The minimum element is in the right half.
	            return binarySearch(nums, mid + 1, right);
	        }
	    }
	}

	public static void main(String[] args) {
		// You must write an algorithm that runs in O(log n) time.

		int[] nums= {1};
		
		System.out.println(findMin(nums));
		
	}

}
