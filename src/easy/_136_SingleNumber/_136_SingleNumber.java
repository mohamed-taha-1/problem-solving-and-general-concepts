package _136_SingleNumber;

public class _136_SingleNumber {

	public static int singNUMber(int[] nums) {
		
	 int x=nums.length;
	 int target=0;		 
		for(int i=0;i<nums.length;i++) {
			
			if(nums[i]!=nums[x-1])  target =nums[i];
			 
			x--;
		}
		
		
		return target;
	}
	public static int singNUMber2(int[] nums) {
		int result = 0;
        for (int num : nums) {
            // XOR each number in the array
            result ^= num;
            System.out.println(result);
        }
        return result;
	}
	
	
	public static void main(String[] args) {
		int[] nums= {2,2,1};
		
		System.out.println( singNUMber2(nums));

	}

}
