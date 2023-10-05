package medium._287_FindtheDuplicateNumber;

public class FindtheDuplicateNumber {

	 public static int findDuplicate(int[] nums) {
		int slow=nums[0];
		int fast=nums[0];
		// find the intersection part
		do {
			slow=nums[slow];
			fast=nums[nums[fast]];
		}
while(fast!=slow);	
		
		fast=nums[0];
		while(slow!=fast) {
			slow=nums[slow];
			fast=nums[fast];
		}
		
	return slow; // Return -1 if no duplicates are found	
	} 
	public static void main(String[] args) {
		int[] arr= {1,3,4,2,2};
		System.out.println(findDuplicate(arr));

	}

}
