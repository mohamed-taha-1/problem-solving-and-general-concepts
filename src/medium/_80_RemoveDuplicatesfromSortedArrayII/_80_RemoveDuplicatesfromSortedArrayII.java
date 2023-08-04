package medium._80_RemoveDuplicatesfromSortedArrayII;

public class _80_RemoveDuplicatesfromSortedArrayII {
	
	 public static int removeDuplicates(int[] nums) {
	 
	    if(nums.length<=2) return nums.length;
	    
	    int start=2;
	    for(int i=start;i<nums.length;i++) {
	    	
	    	if(nums[i]!=nums[start-2]) {
	    		nums[start]=nums[i];
	    		start++;
	    	}
	    	
	    	
	    }
	 
	   return start;
	 
	 }

	public static void main(String[] args) {
		int[] nums = {1,1,1,2,2,3};

		System.out.println( removeDuplicates(nums) );
	}

}
