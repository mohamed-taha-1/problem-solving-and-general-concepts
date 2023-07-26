package medium._55_JumpGame;

public class Soltion2 {
	
	
	public static boolean canJump(int[] nums) {
		
		return recuerion(nums, 0, new boolean[nums.length]);
		
	}
	
	private static boolean  recuerion(int[] nums, int start, boolean[] used) {
		int rows = nums.length;
		int right = rows - 1;
		
		if (rows == 0 || rows == 1)
			return true;
		for(int i= start;i<right; i++) {
			  
			 if(!used[i]) {
				 used[i]=true;
			   int  jump = i + nums[i];
			   if(jump>= right) return true;
			   recuerion(nums,jump, used);
			   used[i]=false;
		  }
		}
		return false;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 3, 1, 1, 4 };

		System.out.println("Can jumb:\t" + canJump(nums));


	}

}
